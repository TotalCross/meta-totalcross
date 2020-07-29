require totalcross.inc

DESCRIPTION = "TotalCross Virtual Machine"

S = "${WORKDIR}/git/TotalCrossVM"

inherit cmake

SECURITY_CFLAGS = ""

EXTRA_OECMAKE += "\
    -DSKIA_SOURCE_DIR=${STAGING_INCDIR}/skia/include \
    -DSKIA_LIBRARIES=${STAGING_LIBDIR}/libskia.so \
    -DSDL2_INCLUDE_DIR=${STAGING_INCDIR}/SDL2 \
    -DPNG_ARM_NEON_OPT=OFF \
"

do_install() {
    install -Dm 0755 ${B}/libtcvm.so ${D}${libdir}/totalcross/libtcvm.so.1
    ln -sf libtcvm.so.1 ${D}${libdir}/totalcross/libtcvm.so
    install -Dm 0755 ${B}/Launcher ${D}${libdir}/totalcross/totalcross-launcher
}

FILES_${PN}-dev = ""

FILES_${PN} += "\
    ${libdir}/totalcross/ \
"

RDEPENDS_${PN} += "libgpiod"

INSANE_SKIP_${PN} += "dev-so rpaths"
