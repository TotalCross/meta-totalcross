LICENSE = "LGPL-2.1"
LIC_FILES_CHKSUM = "file://../../LICENSE;md5=23c2a5e0106b99d75238986559bb5fc6"

DEPENDS = "libsdl2 skia"

inherit features_check

REQUIRED_DISTRO_FEATURES = "opengl"

PV = "6.1.0+${SRCPV}"
BRANCH = "develop"
SRCREV = "e403822fd387e9a9b09c508a2bb6921fc1f11d79"
SRC_URI = "git://github.com/TotalCross/totalcross.git;protocol=https;branch=${BRANCH}"
