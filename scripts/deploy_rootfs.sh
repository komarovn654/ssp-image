rm -rf /home/nikolay/dev/nfsroot/core-image-deimos-beaglebone/*
tar -xpJf /home/nikolay/dev/deimos/build/deploy-ti/images/beaglebone/core-image-deimos-beaglebone.tar.xz -C /home/nikolay/dev/nfsroot/core-image-deimos-beaglebone 
chown -R root:root /home/nikolay/dev/nfsroot/core-image-deimos-beaglebone/  