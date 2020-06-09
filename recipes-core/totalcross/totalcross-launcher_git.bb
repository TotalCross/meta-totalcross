require totalcross.inc

DESCRIPTION = "TotalCross Laucher Machine"

S = "${WORKDIR}/git/TotalCrossVM/src"
B = "${S}"

CXXFLAGS_append = " -I${STAGING_INCDIR}/skia/"
CFLAGS_append = " -I${STAGING_INCDIR}/skia/"

EXTRA_OEMAKE += "\
    BLDDIR='${B}' \
    SDLDIR='${STAGING_LIBDIR}' \
    SDL_INC='${STAGING_INCDIR}/SDL2' \
    SKIADIR='${STAGING_INCDIR}/skia/include' \
    SRCDIR='${S}/launchers/linux' \
    LIBS='-L. -lskia -lstdc++ -lpthread -lEGL -lfontconfig $(SDLDIR)/libSDL2main.a' \
"

do_configure() {
    cp ${S}/../builders/gcc-linux-arm/launcher/Makefile .
}

do_compile() {
    oe_runmake
}

do_install() {
    install -Dm 0755 ${B}/bin/Launcher ${D}${libdir}/totalcross/${PN}
}

FILES_${PN} += "${libdir}/totalcross/"
