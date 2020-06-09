LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=23c2a5e0106b99d75238986559bb5fc6"

DEPENDS = "libsdl2 skia"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opengl"

PV = "6.0.4+${SRCPV}"
BRANCH = "bugfix/deploy-headless"
SRCREV = "2cfacfb7b02032ce041d115c4cf478db7123ea52"
SRC_URI = "git://github.com/OSSystems/totalcross.git;protocol=https;branch=${BRANCH}"
