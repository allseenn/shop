#!/bin/bash

echo "1. Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»" && sleep 3
mkdir "Игрушки для школьников" "Игрушки для дошколят"
ls Игрушки*

echo "2. Создайте в директории «Игрушки для школьников» текстовые файлы - «Роботы», «Конструктор», «Настольные игры»" && sleep 3
touch "Игрушки для школьников"/Роботы "Игрушки для школьников"/Конструкторы "Игрушки для школьников"/"Настольные игры"
if command -v tree > /dev/null; then tree "Игрушки для школьников"; else ls -R  "Игрушки для школьников"; fi 

echo "3. Создайте в директории «Игрушки для дошколят» текстовые файлы «Мягкие игрушки», «Куклы», «Машинки»" && sleep 3
touch "Игрушки для дошколят"/"Мягкие игрушки" "Игрушки для дошколят"/Куклы "Игрушки для дошколят"/Машинки 
if command -v tree > /dev/null; then tree "Игрушки для дошколят"; else ls -R "Игрушки для дошколят"; fi 

echo "4. Объединить 2 директории в одну «Имя Игрушки»" && sleep 3
mv "Игрушки для школьников"/* "Игрушки для дошколят" && rmdir "Игрушки для школьников" && mv "Игрушки для дошколят" "Имя Игрушки"
if command -v tree > /dev/null; then tree "Имя игрушки"; else ls -R "Имя игрушки"; fi 

echo "5. Переименовать директорию «Имя Игрушки» в «Игрушки»" && sleep 3
mv "Имя Игрушки" Игрушки
if command -v tree > /dev/null; then tree "Игрушки"; else ls -R "Игрушки"; fi

echo "6. Просмотреть содержимое каталога «Игрушки»" && sleep 3
ls -al Игрушки
echo "7. Установить и удалить snap-пакет. (Любой, какой хотите)" && sleep 3
if command -v snap > /dev/null; then sudo snap install powershell --classic; else echo "Нет snap"; fi
pwsh -c dir
if command -v snap > /dev/null; then sudo snap remove powershell; else echo "Нет snap"; fi

echo "8. Добавить произвольную задачу для выполнения каждые 3 минуты (Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б)." && sleep 3
echo "*/3 * * * * date >> ~/date" >> ~/tmp
if command -v crontab > /dev/null; then crontab ~/tmp; else echo "Нет crontab"; fi
rm ~/tmp
if command -v crontab > /dev/null; then crontab -l; else echo "Нет crontab"; fi
read -p "Нажмите любую клавишу для выхода ..." end
echo end



