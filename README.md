# Kalkulator BMI i kalorii

Aplikacja mobilna napisana w Kotlinie w Android Studio.

---

## Opis projektu

Aplikacja umożliwia:
- obliczenie wskaźnika BMI
- interpretację wyniku BMI
- podejrzenie przykładowej historii BMI na wykresie
- obliczenie dziennego zapotrzebowania kalorycznego
- korzystanie z listy zakupów 

Użytkownik może wprowadzić swoje dane i otrzymać szybkie wyniki wraz z interpretacją.

---

## Funkcjonalności

- ekran startowy z grafiką
- kalkulator BMI (waga + wzrost)
- interpretacja BMI:
    - niedowaga
    - waga prawidłowa
    - nadwaga
    - otyłość
- kalkulator kalorii
- uwzględnienie:
    - wieku
    - wagi
    - wzrostu
    - płci
    - poziomu aktywności fizycznej
- przykładowy wykres zmian BMI w czasie
- lista zakupów oparta o RecyclerView

---

## Testy i raporty

- Test jednostkowy JUnit: `./gradlew testDebugUnitTest`
- Test Espresso: `./gradlew connectedDebugAndroidTest`
- Raport lint przed poprawkami: `reports/lint-before-fixes.html`
- Raport lint po poprawkach: `reports/lint-after-fixes.html`
- Wynik Monkey: `reports/monkey-result.txt`
- Zrzut ekranu po Monkey: `screenshots/monkey-result.png`

---

##  Wzory
### Wzór Harrisa-Benedicta

**Kobieta:**
655.1 + (9.563 × masa) + (1.850 × wzrost) − (4.676 × wiek)


**Mężczyzna:**
66.5 + (13.75 × masa) + (5.003 × wzrost) − (6.775 × wiek)
### BMI
BMI = masa / (wzrost × wzrost)


---

##  Screeny aplikacji

### Ekran startowy
![Start](screenshots/start.png)

### Kalkulator BMI
![BMI](screenshots/bmi.png)

### Kalkulator kalorii
![Calories](screenshots/calories.png)

---

## Technologie

- Kotlin
- Android Studio
- XML Layout

---

## Autor

Katarzyna Kasperek
