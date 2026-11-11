public class MoviesManager {
    private String[] movies = new String[0]; // Изначально пустой массив
    private int limit; // Лимит для метода findLast

    // Конструктор по умолчанию (лимит 5)
    public MoviesManager() {
        this.limit = 5;
    }

    // Конструктор с параметром (свой лимит)
    public MoviesManager(int limit) {
        this.limit = limit;
    }

    // 1. Добавление нового фильма
    public void add(String movie) {
        // Создаем новый массив на 1 больше
        String[] tmp = new String[movies.length + 1];
        // Копируем старые фильмы
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        // Добавляем новый фильм в конец
        tmp[tmp.length - 1] = movie;
        // Сохраняем новый массив
        movies = tmp;
    }

    // 2. Вывод всех фильмов в порядке добавления
    public String[] findAll() {
        // Возвращаем копию массива, чтобы не сломать внутреннее состояние
        String[] result = new String[movies.length];
        System.arraycopy(movies, 0, result, 0, movies.length);
        return result;
    }

    // 3. Вывод последних фильмов в обратном порядке
    public String[] findLast() {
        int resultLength;
        // Вычисляем правильный размер результирующего массива
        if (movies.length < limit) {
            resultLength = movies.length;
        } else {
            resultLength = limit;
        }

        String[] result = new String[resultLength];

        // Заполняем result из массива movies в обратном порядке
        for (int i = 0; i < resultLength; i++) {
            // Берем элементы с конца оригинального массива
            result[i] = movies[movies.length - 1 - i];
        }

        return result;
    }
}