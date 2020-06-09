require totalcross.inc
DESCRIPTION = "TotalCross SDK"

LIC_FILES_CHKSUM = "file://../LICENSE;md5=23c2a5e0106b99d75238986559bb5fc6"

DEPENDS = "openjdk-8-native"

S = "${WORKDIR}/git/TotalCrossSDK"
B = "${S}"

export JAVA_HOME="${STAGING_DIR_NATIVE}/usr/lib/jvm/openjdk-8-native"

do_compile() {
    ${S}/gradlew dist
}

do_install() {
    install -Dm 0644 ${B}/dist/vm/TCBase.tcz ${D}${libdir}/totalcross/TCBase.tcz
    install -Dm 0644 ${B}/dist/vm/TCFont.tcz ${D}${libdir}/totalcross/TCFont.tcz
    install -Dm 0644 ${B}/dist/vm/TCUI.tcz ${D}${libdir}/totalcross/TCUI.tcz
}

FILES_${PN} += "${libdir}/totalcross/"
