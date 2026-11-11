import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MoviesManagerTest {

    @Test
    public void shouldAddMovie() {
        MoviesManager manager = new MoviesManager();
        manager.add("Фильм 1");
        manager.add("Фильм 2");

        String[] expected = {"Фильм 1", "Фильм 2"};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllWhenEmpty() {
        MoviesManager manager = new MoviesManager();
        String[] expected = {};
        String[] actual = manager.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithDefaultLimit() {
        MoviesManager manager = new MoviesManager(); // Лимит по умолчанию 5
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");
        manager.add("Фильм 5");
        manager.add("Фильм 6"); // Добавили 6-й

        // Ожидаем последние 5 в обратном порядке
        String[] expected = {"Фильм 6", "Фильм 5", "Фильм 4", "Фильм 3", "Фильм 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWithCustomLimit() {
        MoviesManager manager = new MoviesManager(3); // Кастомный лимит 3
        manager.add("Фильм 1");
        manager.add("Фильм 2");
        manager.add("Фильм 3");
        manager.add("Фильм 4");

        String[] expected = {"Фильм 4", "Фильм 3", "Фильм 2"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastWhenLessThanLimit() {
        MoviesManager manager = new MoviesManager(5);
        manager.add("Фильм 1");
        manager.add("Фильм 2");

        // Фильмов меньше, чем лимит. Возвращаем все в обратном порядке
        String[] expected = {"Фильм 2", "Фильм 1"};
        String[] actual = manager.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}