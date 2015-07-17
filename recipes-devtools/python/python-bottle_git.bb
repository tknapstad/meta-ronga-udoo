DESCRIPTION = ""
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://README.rst;md5=1f9017c97709920b7382f39fb402466f"

PV = "0.12+git${SRCPV}"

SRCREV = "813be605c1429ed8be53f159fa7c7b3c05dda79e"
SRC_URI = "git://github.com/bottlepy/bottle.git;branch=release-0.12 \
"

S = "${WORKDIR}/git"

inherit setuptools

DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-lib=${PYTHON_SITEPACKAGES_DIR} \
    --install-data=${datadir}"

