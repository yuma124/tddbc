package tddbc;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 *
 */
@RunWith(Enclosed.class)
public class SemanticVersioningTest {
    public static class インスタンス作成 {
        SemanticVersioning semanticVersioning;
        @Before
        public void 前準備() {
            semanticVersioning = new SemanticVersioning();
        }

        @Test
        public void _1_と_4_と_2_の文字列を渡して_1ドット4ドット2_の文字列を返す () {
            SemanticVersioning semanticVersioning = new SemanticVersioning(1, 4, 2);
            assertEquals("1.4.2", semanticVersioning.getVersion());
        }

        @Test
        public void _2_と_10_と_0_の文字列を渡して_2ドット10ドット0_の文字列を返す () {
            SemanticVersioning semanticVersioning = new SemanticVersioning(2, 10, 0);
            assertEquals("2.10.0", semanticVersioning.getVersion());
        }

        @Test
        public void setMajorした数字をgetMajorで数字を返す () {
            semanticVersioning.setMajor(1);
            assertEquals(1, semanticVersioning.getMajor());
        }

        @Test
        public void setMinorした数字をgetMinorで数字を返す () {
            semanticVersioning.setMinor(1);
            assertEquals(1, semanticVersioning.getMinor());
        }

        @Test
        public void setPatchした数字をgetPatchで数字を返す () {
            semanticVersioning.setPatch(1);
            assertEquals(1, semanticVersioning.getPatch());
        }

        @Test
        public void  majorに_マイナス1を渡すとエラーを返す() {

            try {
                semanticVersioning.setMajor(-1);
            } catch (SemanticVersioningException e) {
                return;
            }

            fail("想定されたエラーが投げられませんでした。");
        }

        @Test
        public void  minorに_マイナス1を渡すとエラーを返す() {

            try {
                semanticVersioning.setMinor(-1);
            } catch (SemanticVersioningException e) {
                return;
            }

            fail("想定されたエラーが投げられませんでした。");
        }

        @Test
        public void  patchに_マイナス1を渡すとエラーを返す() {

            try {
                semanticVersioning.setPatch(-1);
            } catch (SemanticVersioningException e) {
                return;
            }

            fail("想定されたエラーが投げられませんでした。");
        }

    }

    public static class インスタンス比較 {
        @Test
        public void バージョン_1_4_2はバージョン_1_4_2と等しい() {
            SemanticVersioning semanticVersioning1 = new SemanticVersioning(1, 4, 2);
            SemanticVersioning semanticVersioning2 = new SemanticVersioning(1, 4, 2);
            assertTrue(semanticVersioning1.equals(semanticVersioning2));
        }
    }
}
