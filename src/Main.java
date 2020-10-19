

/*Нужна функция, которая будет возвращать строковое значение
 из массива в зависимости от массива долей (вероятностей).
        String func(String[ ] value, int [ ] chance)
        value - массив значений, chance - массив долей.
        Пример входных данных:
        func({"Пейсинг", "не", "нужен"}, {10,61,30});
        Прогнав функцию N раз ожидаю в статистике увидеть
        "Пейсинг" 10/101*N раз, "не" 61/101*N раз и т.д.
*/

import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static String func(String[ ] value, int [ ] chance){
        String a = "errlogic"; // переменная для отладки
              for(int i = 0; i < value.length; i++)
        {
            int boundedRandomValue = ThreadLocalRandom.current().nextInt(0, 100);

            if ( boundedRandomValue <=chance[i]){
                a = value[i];
                break; }
            chance[i+1]+=chance[i];}

        return a;
    }

    public static void main(String[] args) {
        int p = 0;
        int ne = 0;
        int nuzhen = 0;
       for(int i = 0; i < 101; i++) {
            String result = func(new String[]{"Пейсинг", "не", "нужен"}, new int[]{10,10,10});
            if (result=="Пейсинг") {
                 p=p+1;
            }
            else if (result=="не") {
                ne=ne+1;
            }
            else if (result=="нужен") {
                nuzhen=nuzhen+1;
            }
        }
        System.out.println("\"Пейсинг\": " + p + ", \"не\": "+ ne+ ", \"нужен\":"+nuzhen);

    }
}
