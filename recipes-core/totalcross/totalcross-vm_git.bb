require totalcross.inc

DESCRIPTION = "TotalCross Virtual Machine"

S = "${WORKDIR}/git/TotalCrossVM/src"
B = "${S}"

inherit lib_package

CXXFLAGS_append = " -I${STAGING_INCDIR}/skia/ -DPNG_ARM_NEON_OPT=0"
CFLAGS_append = " -I${STAGING_INCDIR}/skia/ -DPNG_ARM_NEON_OPT=0"

EXTRA_OEMAKE += "\
    BLDDIR='${B}' \
    SDLDIR='${STAGING_LIBDIR}' \
    SDL_INC='${STAGING_INCDIR}/SDL2' \
    SKIADIR='${STAGING_INCDIR}/skia/include' \
    SRCDIR='${S}' \
"

SECURITY_STRINGFORMAT = ""
do_configure() {
    cp ${S}/../builders/gcc-linux-arm/tcvm/Makefile .
}

do_compile() {
    oe_runmake
}

do_install() {
    install -Dm 0755 ${B}/bin/libtcvm.so ${D}${libdir}/totalcross/libtcvm.so.1
    ln -sf libtcvm.so.1 ${D}${libdir}/totalcross/libtcvm.so
}

#dev package rename
FILES_${PN} += "${libdir}/totalcross/"
INSANE_SKIP_${PN} += "dev-so"
