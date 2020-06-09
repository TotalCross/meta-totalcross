DEPENDS = "totalcross-vm-core totalcross-launcher"

TOTALCROSS_APP_DIR_NAME ?= "${datadir}/${PN}"
TOTALCROSS_APP_NAME ?= "${PN}"
TOTALCROSS_RUN_OPTIONS ?= ""

do_configure[noexec] = "1"
do_compile[noexec] = "1"

totalcross_install() {
    install -d ${D}${TOTALCROSS_APP_DIR_NAME}
    install -Dm 0644 ${STAGING_LIBDIR}/totalcross/TCBase.tcz ${D}${TOTALCROSS_APP_DIR_NAME}/
    install -Dm 0644 ${STAGING_LIBDIR}/totalcross/TCFont.tcz ${D}${TOTALCROSS_APP_DIR_NAME}/
    install -Dm 0644 ${STAGING_LIBDIR}/totalcross/TCUI.tcz ${D}${TOTALCROSS_APP_DIR_NAME}/
    install -Dm 0755 ${STAGING_LIBDIR}/totalcross/totalcross-launcher ${D}${TOTALCROSS_APP_DIR_NAME}/${TOTALCROSS_APP_NAME}
}
do_install[postfuncs] += "totalcross_install"

totalcross_run_script() {
    cat > ${WORKDIR}/totalcross-run <<EOF
#!/bin/sh

export ${TOTALCROSS_RUN_OPTIONS}
cd ${TOTALCROSS_APP_DIR_NAME}
${TOTALCROSS_APP_DIR_NAME}/${TOTALCROSS_APP_NAME}
EOF

    install -Dm 0755 ${WORKDIR}/totalcross-run ${D}${bindir}/totalcross-run
}
do_install[postfuncs] += "totalcross_run_script"

FILES_${PN} += "${TOTALCROSS_APP_DIR_NAME}"

RDEPENDS_${PN} += "totalcross-vm"

INSANE_SKIP_${PN} += "already-stripped"
