

/*Нужна функция, которая будет возвращать строковое значение
 из массива в зависимости от массива долей (вероятностей).
        String func(String[ ] value, int [ ] chance)
        value - массив значений, chance - массив долей.
        Пример входных данных:
        func({"Пейсинг", "не", "нужен"}, {10,61,30});
        Прогнав функцию N раз ожидаю в статистике увидеть
        "Пейсинг" 10/101*N раз, "не" 61/101*N раз и т.д.

        количество в двух массивах совпадает

        допиши ещё в мейне чтоб статистика считалась
        сколько каких элементов получилось

        вызываешь ее (функцию) с одинаковыми долями - значит
        в статистике примерно одинаковое количество разных строк должно быть
*/

import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static String func(String[] value, int[] chance) {
        String a = "errlogic";
        for (int i = 0; i < chance.length - 1; i++) //цикл для одинаковых значений
        {
            if (chance[i] == chance[i + 1]) {
                String random = (value[new Random().nextInt(value.length)]);
                a = random;
                break;
            } else {
                int rigthBound = 0;
                String count = null;
                for (int j = 0; j < chance.length; j++) //цикл для определения верхней границы рандома
                {
                    rigthBound += chance[j];
                }
                SecureRandom secureRandom = new SecureRandom();

                for (int j = 0; j < value.length; j++) {
                    int boundedRandomValue = secureRandom.nextInt(rigthBound);


                    if (boundedRandomValue <= chance[j]) {
                        a = value[j];
                        break;
                    }
                    chance[i + 1] += chance[i];

                }
            }
            {


            }


        }
        return a;
    }

        public static void main (String[]args){
            int p = 0;
            int ne = 0;
            int nuzhen = 0;
            for (int i = 0; i < 10000; i++) {
                String result = func(new String[]{"Пейсинг", "не", "нужен"}, new int[]{10, 60, 30});
                if (result == "Пейсинг") {
                    p += 1;
                } else if (result == "не") {
                    ne += 1;
                } else if (result == "нужен") {
                    nuzhen += 1;
                }
            }
            System.out.println("\"Пейсинг\": " + p + ", \"не\": " + ne + ", \"нужен\":" + nuzhen);

        }
    }
