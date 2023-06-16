#!/bin/bash

while true; do
    clear
    echo "0. Проверка и установка програмного обеспечения"
    echo "1. Выполнить первую часть контрольной работы"
    echo "2. Выполнить вторую часть контрольной работы"
    echo "3. Удалить результаты заданий"
    echo "4. Справка"
    echo "5. Завершить скрипт"
    read -p "Выберите опцию: " option
    case $option in
        0)  clear && echo "Проверка и установка програмного обеспечения..." && sleep 3
            if ! [ -x "$(command -v tree)" ]; then
            echo 'Пакет tree не установлен. Установка...' >&2
            sudo apt install -f tree
            else
            echo 'Пакет tree уже установлен.'
            fi
            if ! [ -x "$(command -v java)" ]; then
            echo 'Пакет java не установлен. Установка...' >&2
            sudo apt update
            sudo apt install -f default-jdk
            else
            echo 'Пакет java уже установлен.'
            fi
            if ! [ -x "$(command -v mvn)" ]; then
            echo 'Пакет maven не установлен. Установка...' >&2
            sudo apt install -f maven
            else
            echo 'Пакет maven уже установлен.'
            fi
            ;;
        1)  clear && echo "Выполнение первой части контрольной работы..." && sleep 3
            ./linux.sh
            ;;
        2)  clear && echo "Выполнение второй части контрольной работы..." && sleep 3
            javac java/src/main/java/ru/toys/*.java
            java -cp java/src/main/java ru.toys.Main
            ;;
        3)  clear && echo "Очистка задания..." && sleep 3
            rm -rf Игрушки
            rm -rf java/src/main/java/ru/toys/*.class
            ;;
        4) clear
            less README.md
            ;;
        5)  break
            ;;
        *)  echo "Неверный выбор. Пожалуйста, попробуйте снова.";;
    esac
done
