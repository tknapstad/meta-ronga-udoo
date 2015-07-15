

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
    splash \
      package-management \
"

DEPENDS += "\
        gpu-viv-bin-mx6q \
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
IMAGE_INSTALL += "gpu-viv-bin-mx6q \
              qtbase \
                     qtbase-fonts \
                     qtbase-plugins \
                     qtbase-tools \
                     qtwebkit \
                     cinematicexperience \
                     qtwebkit-examples-examples \
                     libgal-mx6 \
                     libvivante-mx6 \
                     gstreamer1.0-plugins-imx-imxeglvivsink \
                     imx-gpu-viv-tools \
                     imx-gpu-viv-demos \
                     binutils \
                     libgcc \
                     nano \
                     dbus \
                     net-snmp \
                     python-core \
                     packagegroup-fsl-gstreamer \
                     packagegroup-fsl-tools-testapps \
                     packagegroup-fsl-tools-benchmark \
                     packagegroup-core-directfb \
                     imx-vpu \
                     imx-test \
                     gstreamer \
                     gst-meta-video \
                     gst-fsl-plugin \
                     gst-plugins-base-app \
                     gst-plugins-base \
                     gst-plugins-good \
                     gst-plugins-good-rtsp \
                     gst-plugins-good-udp \
                     gst-plugins-good-rtpmanager \
                     gst-plugins-good-rtp \
                     ldd \
                     rpm \
                     tslib-conf \
                     tslib-calibrate \
                     qtwebkit-examples-examples \
                     qtmultimedia-examples \
                     qtdeclarative-examples \
                     qt3d-examples \
                     qtbase-examples \
                     grep \
                     strace \
"


# Disabled packages
#    chromium 

inherit core-image distro_features_check

# REQUIRED_DISTRO_FEATURES = "x11"

DISTRO_FEATURES_remove = "x11 wayland"


