
Zadania i opis
====================

1.
1.A. W jakim celu używa się klas abstrakcyjnych, a w jakim interfejsów?

klasa abstrakcyjna jest podobna do interfejsu, np. klasa abstrakcyjna pozwala na dodawanie metod bez implementacji(te metody musza mieć przedrostek abstract tak samo jak klasa)
tak samo jak interfejs(oczywiście klasa abstrakcyjna moze miec zwykłe metody z implementacją, i interfejs też tylko tutaj trzeba dopisać przed metoda "default")(ps. w interfejsie metody są odrazu publiczne i abstrakcyjne).
podobieństw miedzy nimi jest sporo, ale jest taka różnica że,
aby dodac abstrakcje do klasy używa sie słowa kuczowego 'extends' i tu można dodać tylko 1 klase, a dla interfejsu 'implements' i tu można dodać wiecej jak 1 interfejs.
Jako zastosowanie weźmy np. klase abstrakcyjną (nazwijmy ją A z metodą abstrakcyjną np. getName), możemy do niej stworzyć np 2 różne klasy które z niej dziedziczą(niech sie nazywają B, C tutaj implementuje np tą metode), i teraz tak obie te klasy posiadają różną implementacjie tej metody, ale klase B można potraktować jako klase A, tak samo C, wiec mozna zrobić np. liste obiektów klasy A i wrzucić tam B, C, wtedy wywołanie metody getName dla róznych elemntów z tej listy bedzie zwracało różne wyniki co opisuje Polimorfizm. I to samo można by zrobić z intefejsami nie bede tego opisywać tylko to, że zrzutowanie klasy wykorzystujocej np 2 różne interfejsy D, E na np E spowoduje okrojenie jej dostepnych metod i to chyba tyle.
Wiec ostatecznie mógłbym powiedzieć że klas abstrakcyjnych i intefejsu wykorzystuje sie w celu dziedziczenia i polimorfizmu.

1.B. Czym różni się tablica od listy liniowej?

Wiec tak w javie tablica ma z góry(przez programistę) zdefinowany rozmiar,
natomiast w liście liniowej(tak ogólnie kiedyś robiłem taką liste w jezyku c)(w javie przykładem takiej listy jest LinkedList):
- jeśli jest to lista jednokierunkowa to tylko wskaźnik na nastepny element.
- jeśli dwukierunkowa to wskaźnik na następny i poprzedni element.
Więc tak podsumowując jeśli np. byśmy chcieli dodawac nowy element do tablicy to trzeba by wykonywac szereg opercji jak zarezerwować pamieć na nową tablice o rozmiarze +1 w odniesieniu do starej przepisac elementy i dodać nowy element co jest zasoborzerne(w javie jakoś tak podobnie działa ArrayList), 
a w przypadku listy liniowej po prostu sietworzy nowy element, do ostatniego starego daje sie wskaznik na nastepny na ten nowy element ,a w nowym wskaźnik na poprzedni na ostatni stary element, i tak to wygląda.
Wiec konkluzja jest taka wykorzystanie list liniowych jest bardziej optymalne, niż używanie tablic, ale to tylko w przypadku jeśli z gury wiemy że bedziemy chcieli modyfikować skład elementów na danym zbiorze.


2.
Mając tablicę int[] numbers, wypełnioną liczbami całkowitymi i posortowaną malejąco ( numbers[i] > numbers[i+1] ), sprawdź czy występuje w niej liczba int x. Metoda powinna zwracać wartość TRUE, jeśli dana liczba występuje oraz FALSE w przeciwnym wypadku. W rozwiązaniu zależy nam na jak najmniejszej złożoności obliczeniowej (priorytet) oraz pamięciowej. Podaj szacowaną złożoność obliczeniową oraz pamięciową. Poniżej sygnatura metody do napisania.

private boolean search(int[] numbers, int x){}


Więc tak na start mam tablice liczb posortowanych malejąco.
Wiec zrobiłem do tego 2 metody do generowania tablicy i sortowanie javo'we z intefejsem comperable

co do metody search inspirowałem się quicksort'tem tzn. nie sprawdzam wszystkich danych na tablicy
tylko ponieważ wiem że zbiór jest upożątkowany to dziele ten zbiór liczb rekurencyjnie aż znajde tą liczbę w zbiorze 1-2elementowym, wiec:
złożoność obliczeniowa bedzie O(log(n))
złożoność pamięciowa bedzie O(1) ponieważ działam na wczesniej utworzonej tabeli i nie tworze nowych obiektów


3.
Napisz program, który wykorzysta API Kanye Rest https://kanye.rest/ by każdorazowo zaproponować nową perełkę mądrości od Kanye Westa. Program powinien być obsługiwany z poziomu konsoli i obsługiwać komendę "next" by wywołać następny cytat. Program nie potrzebuje oprawy graficznej. Zwróć uwagę na poprawną architekturę aplikacji oraz na czystość kodu.
Dla chętnych, za dodatkowe punkty: dodaj zapisywanie cytatów w pamięci, by upewnić się, że każdy kolejny cytat jest nowy. 


Więc tak zrobiłem aplikacje konsolowo
w aplikacji jest 5 komend(w tym główna wymagana "next")
- next - pobiera cytaty z API Kanye Rest i jeśli cytat się powtórzy to go nie dodaje do listy a tylko komunikuje
- clean - czyści liste z pobranych cytatów
- list - wyświetla liste pobranych cytatów
- end - kończy działanie aplikacji
- help - wyświetla powyższe komendy












