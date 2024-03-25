---
attachments: [Clipboard_2023-11-23-10-47-16.png]
title: Elementary-OS
created: '2021-11-21T12:12:32.693Z'
modified: '2024-02-24T09:49:08.561Z'
---

# Elementary-OS

---

[//]: # "version: 1.0"
[//]: # "author: Iván Rodríguez"
[//]: # "date: 2021-11-21"




# Tabla de contenidos

- [Elementary-OS](#elementary-os)
- [Tabla de contenidos](#tabla-de-contenidos)
  - [Introducción](#introducción)
  - [Instalación](#instalación)
  - [Instalar Sistema Operativo](#instalar-sistema-operativo)
  - [Instalaciones Adicionales](#instalaciones-adicionales)
    - [Actualizar Sistema y codecs](#actualizar-sistema-y-codecs)
    - [Gdebi, Firefox y Tweaks](#gdebi-firefox-y-tweaks)
    - [Instalar LibreOffice](#instalar-libreoffice)
    - [Instalar Editores Gráficos](#instalar-editores-gráficos)
    - [Variables de entorno](#variables-de-entorno)
  - [Pila LAMP](#pila-lamp)
    - [Instalar Apache](#instalar-apache)
    - [Instalar MySQL](#instalar-mysql)
    - [Instalar MySQL WorkBench](#instalar-mysql-workbench)
    - [Instalar PHP 8](#instalar-php-8)
    - [Instalar Dependencias](#instalar-dependencias)
    - [Instalar MongoDB](#instalar-mongodb)
    - [Instalar Composer](#instalar-composer)
    - [Instalar Visual Studio Code](#instalar-visual-studio-code)
    - [Instalar VirtualBox](#instalar-virtualbox)
    - [Instalar otros elementos](#instalar-otros-elementos)
  - [Tecnologías PHP](#tecnologías-php)
    - [Instalar Symfony CLI](#instalar-symfony-cli)
    - [Instalar Drupal](#instalar-drupal)
    - [Instalar Prestashop](#instalar-prestashop)
    - [Instalar WordPress](#instalar-wordpress)
      - [Crear Plugin Wordpress](#crear-plugin-wordpress)
  - [Frameworks Javascript](#frameworks-javascript)
    - [Angular](#angular)
    - [React](#react)
    - [Vue.js](#vuejs)
  - [Python](#python)
    - [Anaconda](#anaconda)
    - [Spyder](#spyder)
    - [PyCharm Community](#pycharm-community)
    - [Django](#django)
  - [Java](#java)
      - [Instalación JDK](#instalación-jdk)
    - [Instalar Tomcat](#instalar-tomcat)
    - [Netbeans](#netbeans)
    - [IntelliJ Idea](#intellij-idea)
    - [Eclipse](#eclipse)
    - [Android Studio y Kotlin](#android-studio-y-kotlin)
    - [Instalar Android Studio](#instalar-android-studio)
  - [.NET](#net)
    - [Instalación .NET](#instalación-net)
    - [HolaMundo .NET](#holamundo-net)
    - [Sección](#sección)

<div style="page-break-after: always;"></div>

## Introducción

[Tabla de contenidos](#tabla-de-contenidos)

Existen distintas opciones para trabajar con Linux:
1. Usar WSL2, es decir, meter Linux como una aplicación mas de Windows.
  - Mas info: https://learn.microsoft.com/es-es/windows/wsl/install
  - No lo recomiendo. Al final consumes muchos recursos.
2. Usar una Máquina virtual (con VMWare o VirtualBox)
  - Estamos en las mismas: demasiados recursos usados.
3. Meter Linux como ÚNICO sistema operativo.
  - Lo ideal... en un múndo idílico. Pero lamentablemente NO estamos en un mundo ideal. Es lo que hay.
4. Tener un arranque dual Windows + Limux.
  - Esta es la opción que recomiendo.
  - IMPORTANTE: SIEMPRE hay que instalar primero Windows!!

Puntos a considerar cuando se hace una instalación DUAL:
1. Antes de empezar HAY QUE HACER UNA COPIA DE SEGURIDAD DE LOS DATOS
2. En el propio Windows, debemos dejar espacio para las particiones de Linux (con 40Gb pueden bastar; yo en mi máquina tengo 800GB - y para mi Windows algo menos de 200GB ;p)
3. Si el ordenador es de marca (como un portátil) lo mas probable es que venga con el UEFI + BitLocker.
  - Debemos ver nuestra clave de bitlocker: aka.ms/bitlocker
  - Si no tenemos cuenta de outlook, nos creamos una. Y damos de alta nuestra copia de Windows.
  - Mas info: https://www.youtube.com/watch?v=6Cx3y-GXbJo
  
- URL
  -
  -

<div style="page-break-after: always;"></div>

## Instalación

[Tabla de contenidos](#tabla-de-contenidos)

Recursos:

- https://www.youtube.com/watch?v=bTWXNTbqV4I

## Instalar Sistema Operativo

Pasos Previos:
En el Windows, debemos buscar (Windows + S) Particiones
Le damos a a Reducir volumen.
Elementary OS necesita al menos 40GB de espacio.

1. Seleccionar idioma de instalación (Español)
2. Clic en Instalar Elementary
3. Seleccionar Disposición teclado (Español)
4. Marcar:

- [x] Descargar Actualizaciones...
- [x] Instalar Programas...

5. Tipo de instalación (Particionado).

- a) Mas Opciones
  Las particiones que deben estar serán, al menos, las siguientes
- 1024MB, Primaria, Ext4 y punto de Montaje: /boot -> Arranque
- 20000MB, Logica, Ext4 y punto de Montaje: /home .> Usuario
- 20000MB, Logica, Ext4 y punto de Montaje: / -> Raiz

6. Elegimos la localización
7. Ponemos los datos de acceso
   IMPORTANTE: Marcar

- [x] Solicitar contraseña

<div style="page-break-after: always;"></div>

## Instalaciones Adicionales

[Tabla de contenidos](#tabla-de-contenidos)

- Recursos:
  -

### Actualizar Sistema y codecs

```console
sudo apt update & upgrade
sudo apt install ubuntu-restricted-extras libavcodec-extra libdvd-pkg
```

- Aprovechamos para instalar VLC

```console
sudo apt update & upgrade
sudo apt install vlc
```

- Vamos a probar nuestro primer video
- https://test-videos.co.uk/bigbuckbunny/mp4-h264
- Si el vídeo tiene franjas verdes: Herramientas > Preferencias > Video > Output > Salida de Video X11

### Gdebi, Firefox y Tweaks

- Gdebi es un instalador de paquetes .deb
  Con esta aplicación (que estará en Aplicaciones > Configuración > Tweaks), podemos poner un botón de minimizar (Apariencia > Windows Controls > Add Minimice Right)
- Tweaks es un configurador del sistema

```console
# Instalación gdebi
sudo apt install gdebi

# Instalación Firefox
# Instalación Firefox, OJO, se usa SNAP.
sudo apt install firefox

# Con respecto al chrome, ir a su página https://www.google.com/intl/es_es/chrome/
# Descargar el .deb e instalar con
# cd ~/Descargas/
# sudo apt install ./google... 


# Instalación Tweaks
sudo apt install software-properties-common
sudo add-apt-repository ppa:philip.scott/pantheon-tweaks
sudo apt update
sudo apt install pantheon-tweaks
```
<div style="page-break-after: always;"></div>

### Instalar LibreOffice

```console
sudo add-apt-repository ppa:libreoffice
sudo apt update
sudo apt install libreoffice

# Idioma español
sudo apt install libreoffice-l10n-es

# Diccionarios
sudo apt-cache search myspell
sudo apt-get install myspell-es
```

- Ahora toca traducirlo al español
  - https://es.libreoffice.org/descarga/libreoffice/
    - Nos vamos a Interfaz de usuario traducida: español

### Instalar Editores Gráficos

- Inkscape, para imágenes vectoriales
```console
sudo add-apt-repository ppa:inkscape.dev/stable
# sudo apt update
sudo apt install inkscape
```

- GIMP, para imágenes de mapa de bits
```console
sudo add-apt-repository ppa:otto-kesselgulasch/gimp
# sudo apt update
sudo apt install gimp
```

### Variables de entorno

Recursos:

- https://www.digitalocean.com/community/tutorials/how-to-read-and-set-environmental-and-shell-variables-on-linux-es

- Es muy recomendable crear nuestra propias variables de entorno para agilizar el trabajo con la consola. Para ello hacemos lo siguiente:

```console
# Visualizar las variables actuales
printenv | less
# Pulsamos q para salir (quit)

# Para visualizar una variable concreta..
printenv HOME
echo $HOME

# Creamos la carpeta donde irán todos los proyectos
mkdir /home/ivanrguez/Proyectos

# Para crear una variable nueva: export VAR="value" dentro de bashrc
sudo nano ~/.bashrc

# Al final del archivo ponemos
export PROYECTOS="/home/ivanrguez/Proyectos"

# IMPORTANTE! Hay que actualizar el bash para que se quede permanente la variable de entorno
source ~/.bashrc

# De ese modo, para pasar a dicho directorio podemos hacer:
cd $HOME/Proyectos
# O bien
cd $HOMEPROJECTS
```
<div style="page-break-after: always;"></div>

## Pila LAMP

- En los siguientes apartados veremos como instalar la pila LAMP
  - L -> Linux
  - A -> Apache
  - M -> MySQL
  - P -> PHP
    Con esto podremos crear aplicaciones web.



### Instalar Apache

[Tabla de contenidos](#tabla-de-contenidos)

- Linux

```console
sudo apt update
sudo apt upgrade
sudo apt install apache2
sudo service apache2 start
```

- Comprobamos que está todo correcto escribiendo en el navegador:
  - http://localhost/

### Instalar MySQL

[Tabla de contenidos](#tabla-de-contenidos)

```console
sudo apt update
sudo apt install mysql-server mysql-client
```

- Ahora toca acceder, pero en primer lugar debemos definir el acceso sin sudo:

```console
sudo mysql -u root -p
```

```sql
use mysql;
ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'root';
FLUSH PRIVILEGES;
exit

# NOTA: En caso de ser MariaDB usar:
# ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';
```

- Solo queda reinicirar MySQL y entrar con root/root

```console
sudo service mysql restart
mysql -u root -p
# Y ahora ponemos la conraseña: root
```

<div style="page-break-after: always;"></div>

### Instalar MySQL WorkBench

[Tabla de contenidos](#tabla-de-contenidos)

Aunque personalmente prefiero usar el cliente de MySQL, mediante comandos en la terminal, es interesante contar con herramientas adicionales para el trabajo con Bases de datos. La mas usada, en entorno gráfico, es la que proporciona el propio Oracle: MySQL WorkBench.

- https://dev.mysql.com/downloads/workbench/

> NOTA IMPORTANTE: La instalación "oficial" de WorkBench (versión 8.0.34) tiene, por ahora, un bug (sobre todo para hacer ingeniería inversa). Recomiendo usar SNAP (ver mas abajo) para hacerlo. O bien hacer una instalación previa como explico ahora...

```console
# Nos vamos a bajar la versión deb para Ubuntu 22.04 64bits
# OJO! Hay dos versiones, usamos el mas pequeño (dbgsym, debug, no necesario para nuestro caso)
cd ~/Descargas
wget https://dev.mysql.com/get/Downloads/MySQLGUITools/mysql-workbench-community_8.0.32-1ubuntu22.04_amd64.deb
sudo apt install ./mysql-workbench-community_8.0.32-1ubuntu22.04_amd64.deb

# Para desinstalar (por si acaso)
sudo dpkg --purge mysql-workbench-community
```

> Instalación con SNAP
```console
sudo apt install snapd
sudo snap install mysql-workbench-community
```

<div style="page-break-after: always;"></div>

### Instalar PHP 8

[Tabla de contenidos](#tabla-de-contenidos)

```console
sudo apt update
sudo apt -y install software-properties-common
sudo add-apt-repository ppa:ondrej/php
Press [ENTER] to continue or Ctrl-c to cancel adding it.
# Pulsamos ENTER
sudo apt update
sudo apt upgrade

sudo apt -y install php                        # Lo mas probable es que el upgrade ya lo instale
php -v                                            # Para ver la versión de PHP

# Instalamos las extensiones que nos harán falta...
sudo apt install php-zip            # Este...
sudo apt-get install php-curl       # Este...
sudo apt-get install php-xml        # Este...
sudo apt-get install php-intl       # Este...
sudo apt-get install php-pgsql
sudo apt-get install php-xsl
sudo apt-get install php-amqp
sudo apt-get install php-gd         # Este...
sudo apt-get install openssl
sudo apt-get install php-redis
sudo apt install php-mysql          # Este...

# Para instalar el Soporte MongoDB
# IMPORTANTE! Si no vas a usar MongoDB, NO LO INSTALES!!
sudo apt install php-dev php-pear
sudo pecl install mongodb

# Vemos el listado de librerias instaladas (incluidas las de arriba)
php -m
```

- Debemos activar los módulos en el PHP.ini
NOTA: Si no hemos instalado MongoDB, no hace falta esto...


```console
sudo nano /etc/php/8.2/cli/php.ini
# Dentro del archivo...
extension=mongodb.so

# CTRL + O (Guardar) y CTRL+X (salir)
sudo service apache2 restart
```

- Seguimos instalando módulos de PHP:

```console
### sodium
# Instalamos CGI
sudo apt-get install php-cgi

# Instalamos además FPM:
# OJO! Muy importante
sudo apt-get install php-fpm
# Hay que activar el FPM en el Apache
sudo a2enmod proxy_fcgi setenvif
sudo a2enconf php-fpm

# Y por último reiniciamos Apache
sudo service apache2 restart
```

<div style="page-break-after: always;"></div>

### Instalar Dependencias

[Tabla de contenidos](#tabla-de-contenidos)

```console
# Instalamos dependencias y nos lo bajamos
sudo apt update
sudo apt install curl php8.2-cli php8.2-mbstring git unzip

# Probamos que version tenemos de PHP
php -v

# ATENCIÓN! Si por alguna razón queremos cambiar a PHP7.4 debemos hacer lo siguiente
# sudo apt -y install php7.4
# sudo a2enmod php7.4
# sudo service apache2 restart
# sudo update-alternatives --set php /usr/bin/php7.4
# sudo update-alternatives --set phar /usr/bin/phar7.4
# sudo update-alternatives --set phar.phar /usr/bin/phar.phar7.4
# sudo update-alternatives --set phpize /usr/bin/phpize7.4
# sudo update-alternatives --set php-config /usr/bin/php-config7.4

# Y volvemos a comprobar
php -v
# Mas info: https://tecadmin.net/switch-between-multiple-php-version-on-ubuntu/
```

- Por último, vamos a comprobar que PHP y Apache se comunican correctamente:

```console
sudo chmod 777 -R /var/www/html # Damos permisos al directorio de publicación
cd /var/www/html
nano info.php
```

- Dentro de info.php ponemos esto:

```console
<?php
// Muestra toda la información, por defecto INFO_ALL
phpinfo();
?>
# Y luego CTRL + O (Guardar) y CTRL + X (salir)
```
<div style="page-break-after: always;"></div>

### Instalar MongoDB

[Tabla de contenidos](#tabla-de-contenidos)

Recursos:

- https://docs.mongodb.com/manual/tutorial/install-mongodb-on-ubuntu/
- https://www.digitalocean.com/community/tutorials/how-to-install-mongodb-on-ubuntu-20-04-es

- El proceso de instalación comienza con añadir los repositorios oficiales:

```console
wget -qO - https://www.mongodb.org/static/pgp/server-5.0.asc | sudo apt-key add -

# Para sacar el listado de claves instalados:
apt-key list

# Creamos un archivo de repositorio para Ubuntu 20.04
# En el mismo comando va el contenido del archivo...
echo "deb [ arch=amd64,arm64 ] https://repo.mongodb.org/apt/ubuntu focal/mongodb-org/5.0 multiverse" | sudo tee /etc/apt/sources.list.d/mongodb-org-5.0.list
```

- Y procedemos con la instalación como tal:

```console
sudo apt update
sudo apt upgrade
sudo apt install -y mongodb-org
```

- Ya solo queda iniciarlo y abrirlo

```console
sudo systemctl start mongod
sudo systemctl status mongod
mongosh
```

<div style="page-break-after: always;"></div>

### Instalar Composer

[Tabla de contenidos](#tabla-de-contenidos)

```console
cd ~
# Bajamos el archivo
php -r "copy('https://getcomposer.org/installer', 'composer-setup.php');"

#Comprobamos que es el correcto
php -r "if (hash_file('sha384', 'composer-setup.php') === '756890a4488ce9024fc62c56153228907f1545c228516cbf63f885e036d37e9a59d27d63f46af1d4d07ee0f76181c7d3') { echo 'Installer verified'; } else { echo 'Installer corrupt'; unlink('composer-setup.php'); } echo PHP_EOL;"

# Hacemos la instalación
sudo php composer-setup.php --install-dir=/usr/local/bin --filename=composer

# Pasos para windows:
# https://getcomposer.org/Composer-Setup.exe
# Seguir el instalador

# Y comprobamos
composer

# Saldrá algo similar a esto:
   ______
  / ____/___  ____ ___  ____  ____  ________  _____
 / /   / __ \/ __ `__ \/ __ \/ __ \/ ___/ _ \/ ___/
/ /___/ /_/ / / / / / / /_/ / /_/ (__  )  __/ /
\____/\____/_/ /_/ /_/ .___/\____/____/\___/_/
                    /_/
Composer version 2.1.5 2021-07-23 10:35:47
```

<div style="page-break-after: always;"></div>

### Instalar Visual Studio Code

[Tabla de contenidos](#tabla-de-contenidos)

Recursos:

- https://ubunlog.com/visual-studio-code-editor-codigo-abierto-ubuntu-20-04/

- Instalación por consola:

```console
sudo apt update
sudo apt update
sudo apt install software-properties-common apt-transport-https wget
wget -q https://packages.microsoft.com/keys/microsoft.asc -O- | sudo apt-key add -
sudo add-apt-repository "deb [arch=amd64] https://packages.microsoft.com/repos/vscode stable main"
sudo apt install code
```

- Extensiones:
  - Sería bueno que tuviesemos la opción de Formatear al guardar para mejorar la visualización del código.
  1. Le damos a CTRL + MAY + X (Extensiones)
  2. Escribimos Spanish Lenguage Pack y le damos a [install]. Pulsamos abajo a la derecha en [Restart].
  3. Escribimos PHP Intelephense y le damos a [Instalar]
  4. Escribimos Markdown All in One y le damos a [Instalar]
  5. Abrimos la configuración de Visual Studio Code: [CTRL + ","]
  6. Buscamos: settings.json. Le damos a Editar en JSON. Y ponemos esto:
     (para los archivo php y json formateamos al guardar)

```json
{
  "[php]": {
    "editor.formatOnSave": true
  },
  "[json]": {
    "editor.quickSuggestions": {
      "strings": true
    },
    "editor.suggest.insertMode": "replace",
    "editor.formatOnSave": true
  }
}
```


> [!IMPORTANT]  
> Si queremos usar JAVA con VSCode, instalamos Extension Pack for Java y para crear un proyecto, CTRL + MAY + P > Create Java Project.

<div style="page-break-after: always;"></div>

### Instalar VirtualBox

[Tabla de contenidos](#tabla-de-contenidos)

- Recursos:
  - https://www.youtube.com/watch?v=ZEADl9fmolA

- Para replicar el entorno de nuestra pila LAMPP de Linux en máquinas Windows, tenemos 3 alternativas
  - Máquinas virtuales (VirtualBox)
  - Usar WSL2
  - Emplear Docker

1. Instalar VirtualBox
> [!WARNING]  
> El enlace para instalar VirtualBox en Windows es este: https://www.virtualbox.org/wiki/Downloads

```console
cd ~/Descargas
wget https://download.virtualbox.org/virtualbox/7.0.14/virtualbox-7.0_7.0.14-161095~Ubuntu~jammy_amd64.deb
sudo apt install ./virtualbox-7.0_7.0.14-161095~Ubuntu~jammy_amd64.deb
```

2. Por ejemplo vamos a instalar una máquina virtual con Bodhi Linux:
> [!TIP]
> Enlace para descargas de la distribución (versión standard): https://www.bodhilinux.com/download/

3. Pulsar en VirtualBox en [Nueva]
4. Poner algo así: Tipo Ubuntu, Memoria: 4096MB, Tamaño Disco Duro virtual Dinámico 40Gb
5. Pulsar [Configuración]
6. Procesadores: 1; Pantalla: 128MB y habilitar aceleración 3D
7. Almacenamiento > Controlador IDE > Vacio: Seleccionar archivo de disco: Seleccionar la ISO bajada (Ej: bodhi-7.0.0-64.iso)

> [!CAUTION]
> Para sistemas Linux, cuando se actualiza las cabeceras del Kernel deja de funciona Virtualbox, hay que seguir los siguientes pasos (muy recomendable, cerrar aplicaciones, sobre todo VirtualBox):
```console
sudo apt install linux-headers-`uname -r`
sudo apt install --reinstall virtualbox-dkms

#ATENCIÓN! La primera vez habrá que reiniciar
# En el menú que sale del SecureBoot, elegir 2a opción y Enroll DKMS
sudo modprobe vboxdrv
```

<div style="page-break-after: always;"></div>

### Instalar otros elementos

[Tabla de contenidos](#tabla-de-contenidos)

- Para poder instalar Symfony CLI (que veremos en el siguiente apartado), debemos tener lo siguiente:
  - cURL
  - Gzip
  - Git

1. Instalar cURL

```console
sudo apt update && sudo apt upgrade
sudo apt install curl
curl --version
```

2. Instalar Gzip

```console
sudo apt update && sudo apt upgrade
sudo apt-get install -y gzip
sudo apt install p7zip-full p7zip-rar
gzip --version
```

3. Instalar Git

```console
sudo apt update
sudo apt install git
git --version

# Ponemos nuestro correo y nuestro nombre...
git config --global user.email "ivanrguez1@yahoo.es"
git config --global user.name "Iván Rodríguez Ruiz"
```

4. Instalar SQLite y SQLite Browser

- Recursos:
  - https://linuxhint.com/install_sqlite_browser_ubuntu_1804/

```console
sudo apt update
sudo apt install sqlite3
sqlite3 --version
sudo apt install sqlitebrowser
```
<div style="page-break-after: always;"></div>

## Tecnologías PHP

[Tabla de contenidos](#tabla-de-contenidos)

### Instalar Symfony CLI

[Tabla de contenidos](#tabla-de-contenidos)

1. Instalamos Symfony CLI

```console
cd ~/Descargas
wget https://get.symfony.com/cli/installer -O - | bash

# lo podemos instalar globalmente con
sudo mv /home/$USER/.symfony5/bin/symfony /usr/local/bin/symfony

# Comprobamos
symfony
```

2. Nos creamos nuestro primer proyecto

```console
mkdir $HOME/Proyectos
cd $HOME/Proyectos
symfony new --full symfony5

# Nos metemos en el directorio del proyecto e iniciamos el servidor
cd $HOME/Proyectos/symfony5
symfony server:start
# Si mas adelante queremos parar el servidor tan solo debemos teclear
### CTRL + C
```

- Y ya podemos ver en el navegador como quedaría:
  - http://127.0.0.1:8000

### Instalar Drupal

[Tabla de contenidos](#tabla-de-contenidos)

- Para instalar Drupal 10 nos hará falta tener composer.
- Estos serán los pasos para realizar la instalación:
1. Por consola:
```console
cd /var/www/html
# Instalamos el núcleo
composer create-project drupal/recommended-project drupal
# Borramos este módulo...
cd drupal 
composer remove drupal/core-project-message

# Instalamos drush
composer require drush/drush

# Creamos el directorio de traducciones
mkdir web/sites/default/files
mkdir web/sites/default/files/translations
sudo chmod 777 web/sites/default/files/translations

# Creamos el archivo de configuración
cp web/sites/default/default.settings.php web/sites/default/settings.php
# Ahora damos permisos
sudo chmod 777 -R web/sites/default
```

2. Ahora activamos las URLs limpias y la Biblioteca UNICODE:
```console
# Para activar en Apache las URLs limpias
sudo a2enmod rewrite

# Nos vamos al archivo de configuración del apache
sudo nano /etc/apache2/apache2.conf

# Hay que dejar esta sección asi:
# <Directory /var/www/>
#        Options Indexes FollowSymLinks
#        AllowOverride All 
#        Require all granted
# </Directory>

# CTRL + O, para guardar y CTRL + X para cerrar.



# Ahora instalamos la Biblioteca UNICODE
sudo apt install php-mbstring
sudo service apache2 restart
```

3. Creamos la BBDD de drupal (o el nombre que queramos) en MySQL/MariaDB:
```console
mysql -u root -p # root
CREATE DATABASE drupal;
exit;
```

4. Ahora toca seguir con la instalación via interfaz web:
  - Nos vamos a http://localhost/drupal/web/core/install.php
  - Pulsamos en [Save and continue]
  - En perfil de instalación usamos el Estandar > [Guardar y continuar]
  - Ponemos los datos de la BBDD: drupal/root/root
  - Por ultimo elegimos usuario clave de acceso (en mi caso admin/root)

5. Corrección de errores tras la instalación:
  - Añadir los trusted_host_patterns
```console
cd /var/www/html/drupal
sudo nano web/sites/default/settings.php
# CTRL + W, para buscar 
# $settings['trusted_host_patterns'] = [
#   '^localhost$',
#   '^127\.0\.0\.1$',
# ];
```

  - Cambiar permisos:
```console
cd /var/www/html/drupal
sudo chmod 755 web/sites/default/
sudo chmod 644 web/sites/default/settings.php 
```

- Vaciar la cache:
```console
cd /var/www/html/drupal
cd vendor/drush/drush
sudo ./drush cr  # Limpia la cache
sudo ./drush     # Presenta todos los comandos de drush
```

- Instalar módulo de forma manual
```console
cd /var/www/html/drupal
composer require drupal/admin_toolbar
cd vendor/drush/drush
sudo ./drush en admin_toolbar admin_toolbar_tools
sudo ./drush cr  # Limpia la cache
```

<div style="page-break-after: always;"></div>

### Instalar Prestashop

[Tabla de contenidos](#tabla-de-contenidos) 

1. 
```console
cd /var/www/html
composer create-project prestashop/prestashop
sudo chmod 
sudo chmod 777 -R prestashop
cd prestashop
```
2. Nos vamos a MYSQL para instalar la BBDD:
```console
mysql -u root -p  # root
CREATE DATABASE prestashop;
exit;
```

3. Ahora nos vamos a la interfaz web:
  - http://localhost/prestashop/prestashop/install-dev/
  - Información tienda: ivan.rodriguez@soltel.es/adminsoltel
  - Ponemos los datos de la BBDD

4. Hay que añadir los ASSETS
```console
cd /var/www/html/prestashop
make assets 
```

5. Y por último accedemos:
  - http://localhost/prestashop/prestashop/admin-dev/index.php

<div style="page-break-after: always;"></div>

### Instalar WordPress

[Tabla de contenidos](#tabla-de-contenidos) 

Voy a incluir en este apartado lo siguiente:
1. Instalar Wordpress
2. Extensiones recomendadas
3. Gestión de Hosting (PiensaSolutions)

Recursos:
- https://es.wordpress.org/

1. Descargar e instalar núcleo y BBDD
```console
cd ~/Descargas
wget https://es.wordpress.org/latest-es_ES.zip
unzip latest-es_ES.zip -d /var/www/html
cd /var/www/html/
sudo chmod 777 -R wordpress

# Hay que crear la BBDD para wordpress en MySQL
mysql -u root -p #root
CREATE DATABASE wordpress;
```

2. Mediante interfaz terminar la instalación
   - http://localhost/wordpress
3. Poner nombre BBDD (wordpress), usuario/clave mysql (root/root) y seguir los pasos.
4. Poner usuario/clave para acceder a Wordpress (admin/soltel, por ejemplo)

- Extensiones Wordpress recomendadas
  - https://es.wordpress.org/plugins/polylang/
  - https://es.wordpress.org/plugins/beaver-builder-lite-version/
  - https://es.wordpress.org/plugins/contact-form-7/
  - https://wordpress.org/plugins/cookiebot/
  - https://wordpress.org/plugins/jetpack/
  - https://wordpress.org/plugins/disable-comments/
  - https://wordpress.org/plugins/breadcrumb-navxt/
  - https://es.wordpress.org/plugins/google-site-kit/
  - https://es.wordpress.org/plugins/classic-editor/
  - https://es.wordpress.org/plugins/simple-social-buttons/
  - https://es.wordpress.org/plugins/equalweb/
  - https://es.wordpress.org/plugins/youtube-embed-plus/
  - https://es.wordpress.org/plugins/tinymce-advanced/
  - https://es.wordpress.org/plugins/classic-widgets/
   
- Extensiones de PAGO
  - https://www.elegantthemes.com/gallery/divi/
  - 

- Para entrar en Wordpress -> admin
  - http://localhost/wordpress/wp-admin/
- Para corregir posible error de subida de archivos
```console
cd /var/www/html/wordpress
sudo nano config.php

# Y dentro añadir esto al final:
# define('ALLOW_UNFILTERED_UPLOADS',  true);
# CTRL + O y CTRL + X
# sudo service apache2 restart
```

- Como instalar un plugin
  - https://es.wordpress.org/plugins/classic-editor/
  - Descargar plugin (ZIP)
  - Descomprimir e instalar
```console
cd ~/Descargas
wget https://downloads.wordpress.org/plugin/classic-editor.1.6.3.zip
unzip classic-editor.1.6.3.zip
mv classic-editor /var/www/html/wordpress/wp-content/plugins
```
  - Irnos a la sección Plugins, ver Classic Editor y [Activar]

#### Crear Plugin Wordpress

[Tabla de contenidos](#tabla-de-contenidos) 

1. Modificar la extensión Intelephense de VSCode
   - Abrir la extensión > Configuración Extensión
   - Ir al apartado stubs (al final) > [Agregar elemento]
     - Añadir wordpress
2. Crear una carpeta y dentro el archivo principal del plugin
```console
cd ~/Descargas
mkdir formulario-soltel
cd formulario-soltel
code formulario-soltel.php
```
3. Ejemplo de plugin básico para recoger formulario:
```php
<?php

/*
Plugin Name: Formulario Trabajadores Soltel
Description: Recopilación de datos trabajadores Soltel
Version: 1.0
Author: Iván Rodríguez
*/

// Voy a añadir la función para el shortcode
function mostrar_formulario()
{
    ob_start();
?>
    <form action="#" method="post">
        <label for="nombre">Nombre</label>
        <input type="text" name="nombre" id="nombre"><br>
        <label for="correo">Correo</label>
        <input type="email" name="correo" id="correo"><br>
        <input type="submit" value="Enviar">
    </form>
<?php
    // Devuelvo el formulario pero limpiando los previos
    return ob_get_clean();
}

// Creo el shortcode
add_shortcode("formulario_soltel", "mostrar_formulario");


// Creo otra función para procesar el formulario
function procesar_formulario()
{
    if ($_SERVER["REQUEST_METHOD"] == "POST") {
        $nombre = sanitize_text_field($_POST['nombre']);
        $correo = sanitize_email($_POST['correo']);
    }

    echo "$nombre <br>";
    echo "$correo <br>";
}

// Añadir la gestión del formulario
add_action("init", "procesar_formulario");
```

4. Para probarlo, activar el plugin, crear una página y dentro de la pestaña HTML poner el shortcode [formulario_soltel]
   
```console

```

<div style="page-break-after: always;"></div>


## Frameworks Javascript

[Tabla de contenidos](#tabla-de-contenidos) 

- En este apartado voy a explicar como instalar:
  - TypeScript
  - Angular 
  - React
  - VUE.js

### TypeScript

[Tabla de contenidos](#tabla-de-contenidos)



### Angular

[Tabla de contenidos](#tabla-de-contenidos)

- Podemos instalar esta capa de Front-end para nuestros proyectos con Symfony

> NOTA: para instalar Angular en Windows se hace a partir del instalador de NodeJS
> El repositorio para todo del 18 es este: https://nodejs.org/download/release/latest-v18.x/
> Windows: https://nodejs.org/download/release/latest-v18.x/node-v18.18.2-x64.msi
> En windows NO hace falta yarn. Una vez instalado NODE, saltar a la sección 3. Instalar cliente Angular

1. Instalar Yarn

```console
curl -sL https://dl.yarnpkg.com/debian/pubkey.gpg | sudo apt-key add -
echo "deb https://dl.yarnpkg.com/debian/ stable main" | sudo tee /etc/apt/sources.list.d/yarn.list
sudo apt update && sudo apt install yarn
yarn --version
```

2. Instalar NodeJS y NPM
- Recursos:
  - https://github.com/nodesource/distributions#installation-instructions
  
```console
sudo apt-get update
sudo apt-get install -y ca-certificates curl gnupg
sudo mkdir -p /etc/apt/keyrings
curl -fsSL https://deb.nodesource.com/gpgkey/nodesource-repo.gpg.key | sudo gpg --dearmor -o /etc/apt/keyrings/nodesource.gpg

NODE_MAJOR=18
echo "deb [signed-by=/etc/apt/keyrings/nodesource.gpg] https://deb.nodesource.com/node_$NODE_MAJOR.x nodistro main" | sudo tee /etc/apt/sources.list.d/nodesource.list

sudo apt-get update
sudo dpkg --remove --force-remove-reinstreq libnode72:amd64
sudo apt-get install nodejs -y
```

> IMPORTANTE: Si hemos instalado una versión incorrecta o queremos otra mas superior, procedemos a desinstalar con lo siguiente:
```console
sudo apt-get purge nodejs 
sudo rm -r /etc/apt/sources.list.d/nodesource.list 
sudo rm -r /etc/apt/keyrings/nodesource.gpg
```
> IMPORTANTE: EN windows una vez acabada la instalación debemos hacer lo siguiente:
> 1. Reiniciar Powershell en modo administrador
> 2. Ejecutar este comando: Set-ExecutionPolicy Unrestricted
> 3. Decir [S] Si
> 4. Volver a reiniciar el powershell 


3. Instalar el Cliente de Angular

```console
sudo npm install -g @angular/cli
# Para ver la versión de NPM (la actual es la 7.5.4)
npm -v
# Instalamos el Cliente...
sudo yarn -npm install -g @angular/cli
# Vemos la versión actual
ng version

# Saldrá algo similar a esto...
Global setting: enabled
Local setting: No local workspace configuration file.
Effective status: enabled

     _                      _                 ____ _     ___
    / \   _ __   __ _ _   _| | __ _ _ __     / ___| |   |_ _|
   / △ \ | '_ \ / _` | | | | |/ _` | '__|   | |   | |    | |
  / ___ \| | | | (_| | |_| | | (_| | |      | |___| |___ | |
 /_/   \_\_| |_|\__, |\__,_|_|\__,_|_|       \____|_____|___|
                |___/
    

Angular CLI: 16.2.0
Node: 18.17.1
Package Manager: npm 9.8.1
OS: linux x64

```

<div style="page-break-after: always;"></div>

### React

[Tabla de contenidos](#tabla-de-contenidos)

1. El primer paso para crear una aplicación de React es tener instalado NodeJS (ver apartado anterior)

2. Por consola, creamos la aplicación:
```console
cd /var/www/html
mkdir react
cd react
npx create-react-app hola-mundo-react
# Need to install the following packages:
# create-react-app@5.0.1
# Ok to proceed? (y) y
cd hola-mundo-react

# Tras un ratito...
npm start
# Aparece en el navegador en la URL http://localhost:3000/
```

3. Editamos el archivo App.js en VS Code
   - En /var/www/html/react/hola-mundo-react/src/App.js
```js
import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <p>Por cierto, ¡Hola Mundo!</p>
      </header>
    </div>
  );
}
export default App;
```

<div style="page-break-after: always;"></div>

### Vue.js

[Tabla de contenidos](#tabla-de-contenidos)

1. Para instalar Vue.js lo primero es tener NodeJS
2. Luego usaremos NPM para hacer la instalación por consola:
```console
sudo npm install -g @vue/cli
```
3. Creamos un proyecto de VUE (puede ser en cualquier parte...)
```console
cd /var/www/html
mkdir vue
cd vue
vue create holamundo-vue
# Pulsamos INTRO para usar la versión 3
# Tras un ratito...
cd holamundo-vue
# Iniciamos el servidor
npm run serve
# Visualizamos la aplicación en el navegador: http://localhost:8080/
```

4. Ahora editamos el archivo App.vuew en VSCode agregando la carpeta al area de trabajo
  - En /var/www/html/vue/holamundo-vue/src/App.vue
```js
<template>
  <img alt="Vue logo" src="./assets/logo.png">
  <HelloWorld msg="Welcome to Your Vue.js App"/>
  <h1>{{ message }}</h1>
</template>

<script>
import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {
    HelloWorld
  },
  data() {
    return {
      message: 'Hola Mundo!'
    };
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>

```

<div style="page-break-after: always;"></div>

## Python

[Tabla de contenidos](#tabla-de-contenidos)

> En windows, bajar el ejecutable: https://www.python.org/downloads/
> Reiniciar Powershell

Por defecto Elementary7, que está basado en Ubuntu LTS 22.04, lleva incorporado Python3. Para ver la versión instalada:

```console
python3 --version
# Python 3.10.12

# Es muy recomendable instalar pip (el gesto de paquetes) a nivel de sistema
sudo apt install python3-pip

# Y ya de paso, algunas librerias que se usan mucho en Ciencias de Datos
sudo python3 -m pip install pandas
sudo python3 -m pip install numpy
sudo python3 -m pip install scikit-learn
sudo python3 -m pip install matplotlib
```

<div style="page-break-after: always;"></div>

### Anaconda
[Tabla de contenidos](#tabla-de-contenidos)

El IDE que vamos a usar es Anaconda:
- https://www.anaconda.com/download#downloads
  
- En linux
Para instalarlo hacemos lo siguiente:
```console
cd Descargas
wget https://repo.anaconda.com/archive/Anaconda3-2023.07-2-Linux-x86_64.sh
# OJO! El bash hay que usarlo SIN SUDO!!
bash Anaconda3-2023.07-2-Linux-x86_64.sh

# Lo primero es aceptar la licencia. Pulsar Av Pág CON CUIDADO!!
Do you accept the license terms? [yes|no]
[no] >>> yes

Anaconda3 will now be installed into this location:
/home/ivanrguez/anaconda3
# Pulsamos INTRO

# Tras un ratito...
done
installation finished.
Do you wish the installer to initialize Anaconda3
by running conda init? [yes|no]
[no] >>> yes

# Y se acaba la instalación inicial
==> For changes to take effect, close and re-open your current shell. <==

If you'd prefer that conda's base environment not be activated on startup, 
   set the auto_activate_base parameter to false: 

conda config --set auto_activate_base false

Thank you for installing Anaconda3!

# Ahora debemos activar el entorno en la terminal
source ~/.bashrc
(base) ivanrguez@Gram16Z90P:~/Descargas$ 
```

Ahora vamos a ver algunas acciones posteriores y el arranque:
```console
# Para ver el listado de paquetes instalados:
conda list
# Ver la version de conda 
conda --version

# Y por último, arrancamos anaconda
anaconda-navigator

# Es posible que nos diga que hay que actualizar. Seguimos las instrucciones y listo.
# Le damos a Launch navigator
```

- Para borrar anaconda, simplemente:
```console
# OJO, que no se pregunta!
rm -rf ~/anaconda3
```

<div style="page-break-after: always;"></div>

### Spyder 

[Tabla de contenidos](#tabla-de-contenidos)

- Instalación Spyder
  - Recurso: https://docs.spyder-ide.org/current/installation.html
  - La forma mas sencilla es iniciar anaconda y en la sección Spyder pulsar en Install
  - También podemos hacerlo por consola (donde incluiremos todas las dependencias en nuesto entorno actual -base-)
```console
conda create -c conda-forge -n spyder-env spyder numpy scipy pandas matplotlib sympy cython
```  

> IMPORTANTE: Anaconda nos permite crearnos entornos. Es ESENCIAL entender que las dependencias se meten a nivel de entorno, no de forma general.

<div style="page-break-after: always;"></div>

### PyCharm Community

[Tabla de contenidos](#tabla-de-contenidos)

 Tenemos que instalar JetBrains ToolBox
  - https://www.jetbrains.com/toolbox-app/
  - En Windows, descargar el .exe e instalar. Luego elegir el PyCharm Community.

```console
# Hay que instalar este paquete:
sudo apt install libfuse2
# Nos vamos a Descargas
cd /Descargas
wget https://download.jetbrains.com/toolbox/jetbrains-toolbox-2.0.5.17700.tar.gz
cd /opt
sudo tar -xvzf ~/Descargas/jetbrains-toolbox-2.0.5.17700.tar.gz 
sudo mv jetbrains-toolbox-2.0.5.17700 jetbrains
jetbrains/jetbrains-toolbox

# Instalado el ToolBox, instalamos el PyCharm con el propio gestor.
```
<div style="page-break-after: always;"></div>


### Django

[Tabla de contenidos](#tabla-de-contenidos)

Framework de Python. Instalación:
```console
# 
```

## Java 

[Tabla de contenidos](#tabla-de-contenidos)

Bibliografia
- https://www.ediciones-eni.com/libro/java-los-fundamentos-del-lenguaje-con-ejercicios-corregidos-9782409036873
- https://www.ediciones-eni.com/libro/jakarta-ee-desarrolle-aplicaciones-web-en-java-9782409039829

Recursos:
- https://www.digitalocean.com/community/tutorials/how-to-install-java-with-apt-on-ubuntu-20-04-es


#### Instalación JDK
[Tabla de contenidos](#tabla-de-contenidos)

Vamos a ver en esta sección como instalar todo la infraestructura Java que vamos a necesitar para el desarrollo de aplicaciones con esta tecnología:
- Empezamos con la opción OpenJDK de la comunidad...
```console
# Instalar el JRE
sudo apt install default-jre
# Instalar el JDK
sudo apt install default-jdk
# Verificar la instalación
java -version
javac -version
```

> IMPORTANTE: Recomiendo ENCARECIDAMENTE no usar la última versión de Java y si alguna anterior LTS. Actualmente la 17
https://en.wikipedia.org/wiki/Java_version_history

- Ahora veremos la instalación Oficial de Oracle
  - 1. Nos vamos a https://www.oracle.com/es/java/technologies/downloads/
  - 2. Descargamos el paquete x64 Debian Package e instalamos...

```console
cd Descargas
wget https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.deb
sudo apt install ./jdk-17_linux-x64_bin.deb

# Si queremos alternar entre Java Oficial y OpenJDK:
sudo update-alternatives --config java
sudo update-alternatives --config javac

# IMPORTANTE!! En ambos casos, poner Java17!!
```

- Ahora vamos a configurar la variable de entorno:
```console
# Volvemos a ejecutar el comando de selección de JDKs
sudo update-alternatives --config java

# Copiamos la salida por defecto
# * 0  /usr/lib/jvm/jdk-17oracle-x64/bin/java      
# Editamos el archivo de configuración de entorno del sistema
sudo nano /etc/environment
# Metemos en la linea siguiente lo copiado menos el /bin/java
JAVA_HOME="/usr/lib/jvm/jdk-17-oracle-x64"
# CTRL + O, para guardar!
# CTRL + X, salir!

# Recargamos el archivo en la sesión actual
source /etc/environment
# Y vemos el valor de la variable
echo $JAVA_HOME
```

- Ya solo nos queda dar permisos (escritura y ejecución) a los ejecutables de Java
```console
cd /usr/lib/jvm/jdk-17-oracle-x64/bin
sudo chmod a+x java  
sudo chmod a+x javac 
```

<div style="page-break-after: always;"></div>

### Instalar Tomcat

[Tabla de contenidos](#tabla-de-contenidos)

> En muchos sitios se recomienda la instalación del contenedor web tomcat como servicio. Personalmente NO lo recomiendo. Sólo usaremos Tomcat en momentos especificos.

> **MUY IMPORTANTE**: NO podemos ejecutar una aplicación de JakartaEE en Tomcat si ya está ejecutandose por otro lado. Tenemos que parar la ejecución de Tomcat (o en su defecto **ELIMINAR LA CARPETA**) 

- Recursos:
  - https://linuxize.com/post/how-to-delete-users-in-linux-using-the-userdel-command/
  - https://linuxize.com/post/how-to-install-tomcat-10-on-ubuntu-22-04/?utm_content=cmp-true

- Página oficial de Descargas
- https://tomcat.apache.org/whichversion.html
  - Recomendable usar versión estable (descartamos el alpha)

```console
# Nos vamos a https://tomcat.apache.org/download-10.cgi
# Ir al apartado core > tar.gz

cd ~/Descargas
wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.17/bin/apache-tomcat-10.1.17.tar.gz
wget https://dlcdn.apache.org/tomcat/tomcat-10/v10.1.17/bin/apache-tomcat-10.1.17-fulldocs.tar.gz
sudo groupadd gp_tomcat 
sudo useradd -s /bin/false -g gp_tomcat -d /opt/tomcat user_tomcat 

# Instalamos el Core y la documentación
cd ~/Descargas
sudo mkdir /opt/tomcat
sudo mkdir /opt/tomcat/apache-tomcat-10 
sudo tar xzvf apache-tomcat-10.1.17.tar.gz -C /opt/tomcat/apache-tomcat-10 --strip-components=1 
sudo mkdir /opt/tomcat/apache-tomcat-10/docs
sudo tar xzvf apache-tomcat-10.1.17-fulldocs.tar.gz -C /opt/tomcat/apache-tomcat-10/docs --strip-components=1 

# Asignamos permisos y probamos
sudo chgrp -R gp_tomcat /opt/tomcat 
cd /opt/tomcat/apache-tomcat-10
sudo chmod -R g+r conf  
sudo chmod -R g+x conf 
sudo chown -R user_tomcat bin logs temp webapps work 
sudo ufw allow 8080  
sudo ufw allow 8000 
sudo su -s "/bin/bash" -c "/opt/tomcat/apache-tomcat-10/bin/startup.sh" user_tomcat

# Y POR FIN, probamos en el navegador
# http://localhost:8080/
```

- Para parar e iniciar de nuevo el servidor:
```console
sudo su -s "/bin/bash" -c "/opt/tomcat/apache-tomcat-10/bin/shutdown.sh" user_tomcat
sudo su -s "/bin/bash" -c "/opt/tomcat/apache-tomcat-10/bin/startup.sh" user_tomcat
```

> IMPORTANTE: En los apartados siguientes vamos a ver cómo instalar varios IDEs. Para el curso usaremos el Eclipse. Pero siempre es bueno aprender a usar los que pongo aquí de forma adicional: NetBeans e IntelliJ Idea.

<div style="page-break-after: always;"></div>

### Netbeans

[Tabla de contenidos](#tabla-de-contenidos)

Para hacer nuestros desarrollo podemos usar diversos IDEs. Desde el propio Visual Studio Code, pasando por el Eclipse hasta el oficial de Oracle: Netbeans. 
Vamos a ver su instalación:
- https://netbeans.apache.org/front/main/download/nb20/

```console
cd ~/Descargas
# Nos bajamos el .deb
wget https://dlcdn.apache.org/netbeans/netbeans-installers/20/apache-netbeans_20-1_all.deb
# Y lo instalamos
sudo apt install ./apache-netbeans_20-1_all.deb
```

<div style="page-break-after: always;"></div>

### IntelliJ Idea

[Tabla de contenidos](#tabla-de-contenidos)

> NOTA: Vamos a usar el IntelliJ Idea Community Edition

Recursos:
- https://www.jetbrains.com/help/idea/installation-guide.html#2220aef6

JetBrains tiene, probablemente, el mejor conjunto de IDEs del mercado. Para descargarlos, usaremos el ToolBox App:
- https://www.jetbrains.com/toolbox-app/

```console
# Nos instalamos esta dependencia
sudo apt install libfuse2

# Nos descargamos el archivo comprimido:
cd Descargas
wget https://download.jetbrains.com/toolbox/jetbrains-toolbox-2.0.4.17212.tar.gz

# Descomprimimos
sudo tar -xvzf jetbrains-toolbox-2.0.4.17212.tar.gz
sudo mv jetbrains-toolbox-2.0.4.17212 jetbrains

# Y arrancamos (OJO, tarda!)
jetbrains/jetbrains-toolbox
```

- Ya solo nos queda estos pasos:
  - 1. Nos descargamos el pack de traducción de JEtBrains
    - https://github.com/macastro/SpanishLanguagePack-JetBrains
    (OJO, normalmente usar el último)
  - 2. Pulsar en IntelliJ Idea Community Edition > Instalar
  - 3. Iniciar en el Menú de aplicaciones
  - 4. Arrastrar desde Descargas a la ventana que se abre y pedirá reiniciar. Y listo!

<div style="page-break-after: always;"></div>


### Eclipse

[Tabla de contenidos](#tabla-de-contenidos)

El Eclipse es uno de los IDEs para java mas populares.  
- Recursos:
  - https://www.eclipse.org/downloads/
  - https://babel.eclipse.org/babel/

- 1. Descargamos e iniciamos el instalador
```console
cd Descargas
wget https://rhlx01.hs-esslingen.de/pub/Mirrors/eclipse/oomph/epp/2023-09/R/eclipse-inst-jre-linux64.tar.gz
tar -xvf eclipse-inst-jre-linux64.tar.gz
cd eclipse-installer
./eclipse-inst
```
- 2. Elegimos Eclipse IDE por Enterprise Java and Web Developers
- 3. Seleccionamos el JVM y la carpeta de instalación (normalmente saldrán ya puestos) y le damos a [Install]
- 4. Le damos a [Launch] y pulsamos en aceptar el directorio de trabajo.
- 5. Para ponerlo en español: Help > Install new software
- 6. En Name ponemos Babel y en Location: https://download.eclipse.org/technology/babel/update-site/latest/
- 7. Tras unos segundos (¡tarda un poquito!), le damos a Babel Language Packs in Spanish, marcando la casilla y pulsamos [Next]
- 8. De nuevo tras varios segundos, le damos a [next], aceptamos la licencia y [Finish]. Cuando termine la instalación (miramos la esquina inferior derecha), reiniciamos Eclipse.
> ATENCIÓN: Hay paquetes que debemos seleccionar que NO están firmados. No pasa nada, está todo controlado ;D

<div style="page-break-after: always;"></div>



### Android Studio y Kotlin

[Tabla de contenidos](#tabla-de-contenidos)

Android Studio es un IDE oficial para el desarrollo de aplicaciones Android. Es una herramienta creada por Google y está diseñada específicamente para ayudar a los desarrolladores a construir aplicaciones para dispositivos Android de manera eficiente.

Android Studio proporciona una variedad de herramientas y características que simplifican y agilizan el proceso de desarrollo de aplicaciones. Algunas de sus características clave incluyen:
- **Editor de código**: Ofrece un editor de código robusto con resaltado de sintaxis, sugerencias inteligentes, completado automático y herramientas de refactorización.
- **Diseñador de interfaces gráficas**: Permite diseñar interfaces de usuario de manera visual mediante el Editor de diseño, lo que facilita la creación y personalización de diseños de pantalla.
- **Emulador de Android**: Incluye un emulador rápido y flexible que permite probar y depurar aplicaciones en diferentes versiones de dispositivos Android y tamaños de pantalla.
- **Herramientas de depuración**: Proporciona herramientas avanzadas de depuración que permiten detectar y solucionar errores en el código, así como analizar el rendimiento de la aplicación.
- **Integración con SDK y herramientas de Google**: Se integra directamente con el kit de desarrollo de software (SDK) de Android y otras herramientas de Google, lo que facilita el acceso a las últimas APIs, bibliotecas y servicios.
- **Compatibilidad con Kotlin y Java**: Ofrece soporte completo para Kotlin y Java, los dos lenguajes de programación principales utilizados para desarrollar aplicaciones Android.

### Instalar Android Studio

[Tabla de contenidos](#tabla-de-contenidos)

- Recursos:
  - https://www.linuxcapable.com/how-to-install-android-studio-on-ubuntu-linux/

1. Añadimos el repositorio
```console
sudo apt update && sudo apt upgrade
sudo add-apt-repository ppa:maarten-fonville/android-studio -y
sudo apt install android-studio
```

2. Iniciar Android Studio. Iniciar configuración...
3. Seleccionar paquetes a instalar y ACEPTAR las condiciones (elegir los del nivel superior)
4. Al finalizar, pulsar [Finish]
> Tras un rato de descargas de paquetes e instalación
5. Pulsar en [New]
6. Seleccionar nombre del proyecto, paquete y el API (recomendable selegir la 24 que es Android9)
7. Cambiamos la fuente del editor
  - File > Settings > Editor > Font

```console
#
```


<div style="page-break-after: always;"></div>

## .NET

[Tabla de contenidos](#tabla-de-contenidos)

- .NET es un conjunto de tecnologías desarrolladas por Microsoft que proporciona un entorno para construir y ejecutar una variedad de aplicaciones en diferentes plataformas. 

- Las principales características de .NET incluyen:
  - Common Language Runtime (CLR): El CLR es el entorno de ejecución de .NET. Proporciona servicios como la gestión de memoria, la seguridad, el manejo de excepciones y la ejecución de código. Permite a los lenguajes de programación de .NET compilar el código a un lenguaje intermedio común (CIL o MSIL) que se ejecuta en el CLR.
  - Framework Class Library (FCL): La FCL es una colección de clases reutilizables y bibliotecas que proporcionan funcionalidades comunes para el desarrollo de aplicaciones. Contiene clases para manejar la entrada/salida, manipular archivos, realizar operaciones de red, trabajar con bases de datos, entre otras tareas.
  - Lenguajes de programación: .NET admite varios lenguajes de programación, incluyendo C#, F#, VB.NET y otros. 
  - Herramientas de desarrollo: Microsoft ofrece herramientas como Visual Studio y Visual Studio Code para desarrollar aplicaciones en .NET. 

<div style="page-break-after: always;"></div>

### Instalación .NET

[Tabla de contenidos](#tabla-de-contenidos)

- Recurso:
  - https://learn.microsoft.com/es-es/dotnet/core/install/linux-ubuntu-2204
- Componentes:
  - 1. SDK (Entorno Desarrollo + Ejecución)
  - 2. CLR (Entorno Ejecución) -> ASP.NET Core

1. Instalamos el SDK
```console
sudo apt-get update
sudo apt-get install -y dotnet-sdk-7.0

# Visualizar las versiones instaladas
dotnet --list-sdks
dotnet --list-runtimes

# Para ver la ayuda del comando:
dotnet --help
```

2. Si luego queremos instalar paquetes adicionales de .NET, lo haremos por consola.
  - Por ejemplo Newtonsoft.Json, que es una biblioteca muy popular para trabajar con JSON en .NET
```console
dotnet add package Newtonsoft.Json
```

3. Instalamos Visual Studio Code como IDE
  - Dentro, instalamos la extensión C# (el que viene con ese nombre de Microsoft, no el que pone C# Dev Kit)

### HolaMundo .NET
[Tabla de contenidos](#tabla-de-contenidos)

- Usar la consola de VS Code: Ver > Terminal
1. Creamos la carpeta del proyecto y su estructura:
```console
# Nos creamos una carpeta (puede ir en cualquier lago, yo lo pongo en el apache)
cd /var/www/html
mkdir c#
cd c#

# Creamos el esqueleto del proyecto
dotnet new console --framework net7.0
```

2. Abrimos el proyecto en VSCode
  - Archivo > Agregar carpeta al área de trabajo
    - Seleccionar la carpeta /var/www/html/c#
3. Abrir el archivo Program.cs y editarlo:
```c#
// See https://aka.ms/new-console-template for more information
Console.WriteLine("Hola Mundo!");
```
4. Ejecutamos el proyecto en la misma terminal:
```console
cd /var/www/html/c#
dotnet run
```

<div style="page-break-after: always;"></div>

### Sección
[Tabla de contenidos](#tabla-de-contenidos)

```console
# ...
```
