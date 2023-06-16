# Инструкция
## Описание
Данная инструкция посвящена второму заданию контрольной работы и включает две задачи: 
1. Ubuntu - скрипт linux.sh
2. Java - папка проекта java

Подробное описание задач смотрите в разделе [Задание 2. Магазин игрушек (Java)](#Задание-2)

Программы каждой задачи могут быть запущенны по отдельности, либо совместно. Архитектура обеих программ построена таким образом, что используются общие папки и файлы.

## Совместный запуск (Cразу двух задач)
Программы обеих задач размещены в одной папке shop на гитхабе.
Для запуска программ достаточно клонировать  репозиторий в любую удобную директорию и запустить стартовый скрипт
```
git clone https://github.com/allseenn/shop.git
cd shop
bash start.sh
```

<img src=pics/01.png>

Рекомендуется запуск на Ubuntu 20.04 или 22.04.

Перед выполнением задач, выбрав 0, можно установить пакеты, необходимые для выполнения задач.
Для запуска задачи по Ubuntu нужно выбрать цифру 1.

### Ubuntu
Вызывается как часть скрипта start.sh пункт 1. Либо как отдельный скрипт linux.sh

<img src=pics/02.png>

С небольшой паузой в 3 секунды, начинают выполняться все 8 заданий. Перед началом задания выводится его текст. По окончании результат.

В некоторых заданиях необходимы права администратора, при соответствующем запросе вводим пароль рута (для установки и удаления пакетов).

По завершении всех 8 задач, необходимо нажать любую клавишу для выхода, либо возврата в главное меню стартового скрипта script.sh

### Java
Проект можно запустить перейдя в папку java
```
cd java
code .
```
Либо в стартовом скрипте start.sh выбрать пункт 2.
Сначала запуститься сборка классов, через несколько секунд запуститься программа с меню:

<img src=pics/03.png>

Программа проверит наличие директорий оставшихся после задания с Ubuntu. Если файлов и папок нет, программа создаст их автоматически, если они остались от предыдущего задания, программа будет их использовать для хранения данных.

В соответствии с прошлым заданием, в магазине несколько видов игрушек:
- Конструкторы
- Куклы
- Машинки
- Мягкие игрушки
- Настольные игры
- Роботы

Например, можно добавить конструктор с помощью цифры 1:

<img src=pics/04.png>

Конструктор Лего добавиться в соответствующий файл "Конструкторы" и будет иметь уникальный id и рандомный вес от 0 до 100.
Тоже самое и для остальных категорий:

<img src=pics/05.png>

<img src=pics/06.png>

<img src=pics/07.png>

<img src=pics/08.png>

<img src=pics/09.png>

С помощью цифры 7 можно вывести все игрушки в магазине:

<img src=pics/10.png>

Отобразятся все игрушки по разделам, с указанием их id, названия и веса

Для возврата в главное меню нажмите 0.

Атрибуты игрушки можно изменить, для этого нужно отобразить с помощью цифры 7 весь список, скопировать id нужной игрушки, вернуться в главное меню и нажать цифру 8

<img src=pics/11.png>

После ввода нужного id отобразится подменю:

<img src=pics/12.png>
Можно поменять вес игрушки, изменить имя или удалить ее.

4 - возврат в главное меню. 5. Завершение программы.

### Розыгрыш приза

Цифра 9 главного меню, осуществляет рандомный выбор игрушки на основе ее веса.

Ее имя отображается на экране и она удаляется из соответствующего файла, где она хранилась.

Цифра 0 завершает программу Java и возвращается в главное меню.

### Завершение
Базу игрушек т.е. файлы и папку Игрушки, можно удалить с помощью цифры 4 стартового скрипта start.sh
Цифра 5 завершает скрипт.

# Задание-2 
## Магазин игрушек (Java)
Проект состоит из 2 частей:

Linux - Выполнить в командной строке
Программа на Java - Необходимо написать программу, для розыгрыша игрушек в магазине детских товаров.

Эти 2 части не взаимосвязанные. Т.е. не нужно с помощью программы на Java выполнять команды в Linux
 
*У кого не было курса по Linux – Пропускаем 1 часть по Linux. При сдаче проекта укажите это.
 
Подробное описание задач – ниже.

## Как сдавать проект
 
Первую часть по Linux можно сдавать скринами терминала, текстовым или PDF файлом и приложить к проекту и\или добавить на github. 
(У кого не было этого курса - пропускаем это задние)

Вторую часть программы на Java – выкладываем в отдельный общедоступный репозиторий Github
Программа должна запускаться и работать, ошибок при выполнении программы быть не должно.
 
 
## Задача 1
 
1. Используйте команды операционной системы Linux и создайте две новых директории – «Игрушки для школьников» и «Игрушки для дошколят»
2. Создайте в директории «Игрушки для школьников» текстовые файлы - «Роботы», «Конструктор», «Настольные игры»
3. Создайте в директории «Игрушки для дошколят» текстовые файлы «Мягкие игрушки», «Куклы», «Машинки»
4. Объединить 2 директории в одну «Имя Игрушки»
5. Переименовать директорию «Имя Игрушки» в «Игрушки»
6. Просмотреть содержимое каталога «Игрушки».
7. Установить и удалить snap-пакет. (Любой, какой хотите)
8. Добавить произвольную задачу для выполнения каждые 3 минуты (Например, запись в текстовый файл чего-то или копирование из каталога А в каталог Б).
 
## Задача 2
 
Необходимо написать программу – розыгрыша игрушек в магазине детских товаров.

Стараемся применять ООП и работу с файлами.

Если какой-то пункт не изучали и не знаете, как сделать, то можете сделать своим способом. Например, у кого в курсе не было ООП, то применяем списки\массивы\словари
 
## Желательный функционал программы:

В программе должен быть минимум один класс со следующими свойствами:
- id игрушки,
- текстовое название,
- количество
- частота выпадения игрушки (вес в % от 100)
 
Метод добавление новых игрушек и возможность изменения веса (частоты выпадения игрушки)

Возможность организовать розыгрыш игрушек.

Например, следующим образом:
С помощью метода выбора призовой игрушки – мы получаем эту призовую игрушку и записываем в список\массив.

Это список призовых игрушек, которые ожидают выдачи.

Еще у нас должен быть метод – получения призовой игрушки.

После его вызова – мы удаляем из списка\массива первую игрушку и сдвигаем массив. А эту игрушку записываем в текстовый файл.

Не забываем уменьшить количество игрушек

К написанию программы можно подойти более творчески и делать так, как Вы поняли задание. Немного менять и отходить от примера выше.
