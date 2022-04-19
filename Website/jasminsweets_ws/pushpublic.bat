@echo off

start hugo
start Compress-Archive -Path .\public\ -DestinationPath .\archives\public
start cd archives
start scp public.zip Jasmin:/var/www/html
start ssh Jasmin
start cd /var/www/html/
start sudo unzip public.zip
start sudo rm public.zip
start cd public
start sudo mv * ../
start sudo rm -r public/
start exit