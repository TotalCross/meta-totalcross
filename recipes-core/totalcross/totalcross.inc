LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=23c2a5e0106b99d75238986559bb5fc6"

DEPENDS = "libsdl2 skia"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opengl"

PV = "6.0.4+${SRCPV}"
BRANCH = "develop"
SRCREV = "bd9fb513133ee1309a8ff50dbcabbd6a1ffce58f"
SRC_URI = "git://github.com/TotalCross/totalcross.git;protocol=https;branch=${BRANCH}"
