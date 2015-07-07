require recipes-bsp/u-boot/u-boot.inc

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=025bf9f768cbcb1a165dbe1a110babfb"

SRC_URI[md5sum] = "e7ef0d7d8edeb7753de56120b475f72b"
SRC_URI[sha256sum] = "59c3aaab346e73aa1b2a0ff692f1661337d3c3eeccade328ff3554a26f8dd7a8"

COMPATIBLE_MACHINE = "(mx6)"
DEPENDS_mxs += "elftosb-native openssl-native"
PROVIDES += "u-boot"
PV="norbit-seco-2013"

SRC_URI = "file://uboot_2013.10-214db3b4b9f7c5304561de3f059c0402e460fc26.tar.gz \
	   file://0001-modified-seco-conf-for-yocto-meta.patch \
       file://0002-seco-buildscript-config.patch"

S = "${WORKDIR}/git"

do_compile () {
   compile.sh
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
