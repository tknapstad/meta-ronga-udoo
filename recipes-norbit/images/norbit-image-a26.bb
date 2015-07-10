

SYSTEMD_INSTALL = " \
    systemd \
    systemd-compat-units \
    systemd-speed-hacks \
    udev-systemd \
    rsyslog-systemd \
"

SYSV_INSTALL = " \
    udev \
    sysvinit \
    initscripts \
"

IMAGE_FEATURES += "\
     ssh-server-openssh \
    splash \
      package-management \
      x11-base \
"

DEPENDS += "\
      libpng \
"
LICENSE = "MIT"

#from QT-in-use-common:
IMAGE_INSTALL += " \
    base-files \
    base-passwd \
    busybox \
    ${@base_contains("MACHINE_FEATURES", "systemd", "${SYSTEMD_INSTALL}", "${SYSV_INSTALL}", d)} \
    packagegroup-base \
"

# A26 specific packages:
IMAGE_INSTALL += " \
    directfb \
    directfb-examples \
    nano \
    openssh \
    firefox \
    webkit-gtk \
"

# Disabled packages
#    chromium 

inherit core-image distro_features_check

# REQUIRED_DISTRO_FEATURES = "x11"



