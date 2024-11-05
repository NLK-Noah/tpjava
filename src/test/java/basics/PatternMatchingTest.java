package basics;




import org.javagrader.Grade;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


@Grade
public class PatternMatchingTest {

    @Test
    @Grade(value = 1, cpuTimeout = 1000)
    public void test1() {
        assertEquals(3, PatternMatching.find("Hello", "abcHello"));
        assertEquals(-1, PatternMatching.find("hello", "abcHello"));
        assertEquals(-1, PatternMatching.find("Hello", "abcHell"));
        assertEquals(0, PatternMatching.find("Hello", "HelloHelloHello"));
        assertEquals(4, PatternMatching.find("Hello", "elloHelloHello"));
    }

    @Test
    public void testEmptyPattern() {
        assertEquals(-1, PatternMatching.find("Hello", "")); // Motif vide
    }

    @Test
    public void testEmptyValue() {
        assertEquals(-1, PatternMatching.find("", "abcHello")); // Valeur vide
    }

    @Test
    public void testPatternWithOnlySpaces() {
        assertEquals(-1, PatternMatching.find("Hello", "     ")); // Cherche "Hello" dans des espaces
    }

    @Test
    public void testSpacesAsPattern() {
        assertEquals(-1, PatternMatching.find("     ", "abcHello")); // Cherche des espaces dans "abcHello"
    }

    @Test
    public void testSingleSpacePattern() {
        assertEquals(-1, PatternMatching.find(" ", " ")); // Un seul espace
    }

    @Test
    public void testMultipleSpacesPattern() {
        assertEquals(-1, PatternMatching.find("     ", "     ")); // Plusieurs espaces dans les deux chaînes
    }

    @Test
    public void testPatternWithSpacesBetweenCharacters() {
        assertEquals(-1, PatternMatching.find("Hello", "  H  e  l  l  o  ")); // Cherche "Hello" avec des espaces entre
    }

    @Test
    public void testPatternWithSpacesAtEnd() {
        assertEquals(0, PatternMatching.find("Hello", "Hello   ")); // "Hello" avec des espaces à la fin
    }

    @Test
    public void testPatternWithSpacesAtStart() {
        assertEquals(-1, PatternMatching.find("   Hello", "abcHello")); // "   Hello" dans "abcHello"
    }

    @Test
    public void testPatternWithSpacesAroundCharacters() {
        assertEquals(-1, PatternMatching.find("Hello", " H e l l o ")); // "Hello" avec des espaces autour
    }

    @Test
    public void testOnlySpacesInPattern() {
        assertEquals(-1, PatternMatching.find("   ", "   ")); // Trois espaces dans les deux chaînes
    }
}