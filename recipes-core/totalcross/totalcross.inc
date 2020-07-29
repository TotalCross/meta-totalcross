LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://../LICENSE;md5=23c2a5e0106b99d75238986559bb5fc6"

DEPENDS = "libsdl2 skia"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opengl"

PV = "6.1.0+${SRCPV}"
BRANCH = "feature/build-macos"
SRCREV = "7fe33fa97f48f2651ef7eec705ea7ba2a20b8d7d"
SRC_URI = "git://github.com/TotalCross/totalcross.git;protocol=https;branch=${BRANCH}"
