# Useful bitbake commands:
## Show environments:
```sh
bitbake -e core-image-deimos | grep ^UBOOT_MACHINE=
```
## Show appends:
```sh
bitbake-layers show-appends
```
## Show layers:
```sh
bitbake-layers show-layers
```
## Show recipes:
```sh
bitbake-layers show-recipes
```
## Git patches. Example of TI u-boot modification:
From the build directory run:
```sh
devtool modify u-boot-ti-staging
```
> Note: Dir workspace will be created and added to the bblayers. Also, repo u-boot-ti-staging will be cloned.

Then, modify whatever you want in the cloned repo.

# TFTP NFS
## Image install
```sh
IMAGE_INSTALL:append = " nfs-utils nfs-utils-client"
```
## NFS host setup
Setup the nfs root here (for example /home/nikolay/dev/nfsroot/core-image-deimos-beaglebone  *(rw,sync,no_subtree_check,no_root_squash))
```sh
sudo vim /etc/exports
sudo exportfs -a
sudo systemctl restart nfs-kernel-server
showmount -e 192.168.0.16
```
## TFTP host setup
```sh
sudo apt install tftpd-hpa
```
Once the package is installed, view the contents of /etc/default/tftpd-hpa, and check what the TFTP
server home directory (TFTP_DIRECTORY setting). If /srv exists on your system, it should be /srv/tftp,
otherwise /var/lib/tftpboot/.
If you wish to make a change to this file, you will have to restart the TFTP server:
```sh
sudo /etc/init.d/tftpd-hpa restart
```
## U-Boot envs
```sh
setenv serverip 192.168.0.16
setenv ipaddr 192.168.0.100
setenv bootargs root=/dev/nfs rw ip=192.168.0.100 console=ttyS0,115200n8 nfsroot=192.168.0.16:/home/nikolay/dev/nfsroot/core-image-deimos-beaglebone,nfsvers=3,tcp
setenv nfsboot 'tftp 0x81000000 zImage; tftp 0x82000000 am335x-boneblack-beaglebone.dtb; bootz 0x81000000 - 0x82000000'
saveenv
run nfsboot
```

## EoU
BBB
```sh
modprobe g-ether
ifconfig usb0 192.168.7.2 netmask 255.255.255.0
```

