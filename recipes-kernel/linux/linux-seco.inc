# Adapted from linux-imx.inc, copyright (C) 2012, 2013 O.S. Systems Software LTDA
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "Linux kernel for SECOSBC-A62"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

require recipes-kernel/linux/linux-imx.inc

# Put a local version until we have a true SRCREV to point to
LOCALVERSION ?= "+yocto"
SCMVERSION = "n"

# SRC_URI for SECOSBC-A62 kernel
SRC_URI = "file://kernel_and_modules_3.0.35-a0e78c16eb113953ea00f04cffa85298b725be55.tar.gz \
           file://defconfig \
"

S = "${WORKDIR}"

# KERNEL_IMAGETYPE = "uImage"

# The kernel makefile fails to find the i.MX6 firmware when doing
# out of tree builds in a separate folder. Add a symlink prior to
# do_compile so that the kernel builds.
do_compile_prepend () {
   mkdir -p ${B}/firmware/imx/sdma
   ln -sf ${S}/firmware/imx/sdma/sdma-imx6q-to1.bin ${B}/firmware/imx/sdma/sdma-imx6q-to1.bin
}
