package org.java.practice;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * Created by 晋阳 on 2018/1/7.
 */
public class UnitTest {

    public static void printArr(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }

    @Test
    public void iiiii() {
        int[] a = {1, 2, 3, 4, 5};
        printArr(Arrays.copyOf(a,3));
    }

    @Test
    public void salfj() {

        int cap = 16;
        System.out.println(cap>>>2);
        int min = 0x80000000;
        System.out.println(min);
        int max = 0x7fffffff;
        System.out.println(max);
    }

    @Test
    public void safdlkjjfdsa() {
        System.out.println((1-1)/2);
        System.out.println((2-1)/2);
        System.out.println((3-1)/2);
        System.out.println((4-1)/2);

        System.out.println(Math.log(5)/Math.log(2));
    }

    @Test
    public void asjlffklsajdfs() {

        //3814697265625
        //5555550000000
        //19073486328125
        System.out.println(BigDecimal.valueOf(Math.pow(5,19)).toString());
        System.out.println("________________________________");
        System.out.println(3/5);
        System.out.println(8/5);
        System.out.println(12/5);
        System.out.println(16/5);
        System.out.println("________________________________");
        System.out.println("nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy".length());
        System.out.println("0000000000000000000000000".length());
    }

    @Test
    public void safdoiio() {
        String myAnswer = "[\"Hqx\",\"KHe\",2]\n" +
                "[\"YIO\",\"Gqe\",2]\n" +
                "[\"srJ\",\"Gcx\",6]\n" +
                "[\"dpw\",\"wtx\",9]\n" +
                "[\"uJd\",\"Xrp\",9]\n" +
                "[\"uMG\",\"YfK\",9]\n" +
                "[\"Gcx\",\"xYp\",11]\n" +
                "[\"Ows\",\"LIO\",11]\n" +
                "[\"YfK\",\"fYZ\",11]\n" +
                "[\"MJf\",\"Kdc\",12]\n" +
                "[\"Ltf\",\"xOK\",12]\n" +
                "[\"teq\",\"eZY\",14]\n" +
                "[\"wMH\",\"ebf\",14]\n" +
                "[\"KMH\",\"HaX\",15]\n" +
                "[\"eIK\",\"xIe\",15]\n" +
                "[\"Ows\",\"efs\",16]\n" +
                "[\"tcJ\",\"Kdc\",16]\n" +
                "[\"teq\",\"wMH\",16]\n" +
                "[\"Lfe\",\"tcJ\",17]\n" +
                "[\"sHI\",\"ZqG\",19]\n" +
                "[\"OrH\",\"Kdc\",21]\n" +
                "[\"uJd\",\"wGe\",21]\n" +
                "[\"bGe\",\"xYp\",22]\n" +
                "[\"GXM\",\"MIp\",23]\n" +
                "[\"Gcx\",\"efs\",25]\n" +
                "[\"xLY\",\"HXe\",25]\n" +
                "[\"fYZ\",\"KfY\",27]\n" +
                "[\"xqH\",\"wOc\",27]\n" +
                "[\"wGe\",\"Kdc\",29]\n" +
                "[\"xqH\",\"wMH\",31]\n" +
                "[\"MIp\",\"ZqG\",32]\n" +
                "[\"MxL\",\"uKw\",32]\n" +
                "[\"wOc\",\"Ltf\",34]\n" +
                "[\"Oft\",\"wcf\",37]\n" +
                "[\"MZu\",\"Gqe\",38]\n" +
                "[\"Idc\",\"MZu\",39]\n" +
                "[\"bGe\",\"qZt\",39]\n" +
                "[\"fps\",\"Lfe\",39]\n" +
                "[\"pYr\",\"Oft\",39]\n" +
                "[\"JKr\",\"brp\",40]\n" +
                "[\"MxL\",\"Gcx\",42]\n" +
                "[\"Hqx\",\"Gqe\",43]\n" +
                "[\"JKr\",\"xYp\",44]\n" +
                "[\"eIK\",\"MxL\",44]\n" +
                "[\"bGe\",\"tqL\",45]\n" +
                "[\"HaX\",\"wOc\",46]\n" +
                "[\"JIb\",\"uMG\",46]\n" +
                "[\"bGe\",\"uMG\",51]\n" +
                "[\"pYr\",\"xOK\",53]\n" +
                "[\"ZqG\",\"srJ\",54]\n" +
                "[\"IqZ\",\"wcf\",56]\n" +
                "[\"MJf\",\"rYq\",56]\n" +
                "[\"MxL\",\"dOH\",57]\n" +
                "[\"uOd\",\"Ldp\",58]\n" +
                "[\"qbx\",\"brp\",59]\n" +
                "[\"wOc\",\"ZqG\",60]\n" +
                "[\"Lfe\",\"Oft\",61]\n" +
                "[\"ceH\",\"KMc\",61]\n" +
                "[\"sJa\",\"uJd\",63]\n" +
                "[\"xfG\",\"wMa\",65]\n" +
                "[\"uwt\",\"eZY\",66]\n" +
                "[\"dpw\",\"Xrp\",67]\n" +
                "[\"xLY\",\"MxL\",69]\n" +
                "[\"uKw\",\"pOq\",71]\n" +
                "[\"xfG\",\"tqL\",74]\n" +
                "[\"bYs\",\"xYp\",75]\n" +
                "[\"qfa\",\"Hqx\",75]\n" +
                "[\"Hqx\",\"KfY\",81]\n" +
                "[\"Lsp\",\"ZXI\",82]\n" +
                "[\"uJd\",\"ZJf\",82]\n" +
                "[\"wtx\",\"ZXI\",82]\n" +
                "[\"cpu\",\"cad\",85]\n" +
                "[\"JMK\",\"Ows\",86]\n" +
                "[\"uwt\",\"xYL\",90]\n" +
                "[\"ceH\",\"Gcx\",91]\n" +
                "[\"fps\",\"wfI\",91]\n" +
                "[\"Geb\",\"Gfp\",93]\n" +
                "[\"cad\",\"srJ\",94]\n" +
                "[\"Gqe\",\"Gfp\",110]\n" +
                "[\"wbZ\",\"wOc\",111]\n" +
                "[\"cZr\",\"qZt\",131]\n" +
                "[\"YIO\",\"sXI\",144]\n" +
                "[\"ZfH\",\"brp\",147]\n" +
                "[\"pOq\",\"Ldp\",154]\n" +
                "[\"GMK\",\"uwt\",157]\n" +
                "[\"ubI\",\"uOd\",160]\n" +
                "[\"Hdq\",\"dpw\",161]\n" +
                "[\"pwa\",\"wfI\",167]";

        String trueAnswer = "[\"Hqx\",\"KHe\",2]\n" +
                "[\"YIO\",\"Gqe\",2]\n" +
                "[\"srJ\",\"Gcx\",6]\n" +
                "[\"dpw\",\"wtx\",9]\n" +
                "[\"uJd\",\"Xrp\",9]\n" +
                "[\"uMG\",\"YfK\",9]\n" +
                "[\"Gcx\",\"xYp\",11]\n" +
                "[\"Ows\",\"LIO\",11]\n" +
                "[\"YfK\",\"fYZ\",11]\n" +
                "[\"Ltf\",\"xOK\",12]\n" +
                "[\"MJf\",\"Kdc\",12]\n" +
                "[\"teq\",\"eZY\",14]\n" +
                "[\"wMH\",\"ebf\",14]\n" +
                "[\"KMH\",\"HaX\",15]\n" +
                "[\"eIK\",\"xIe\",15]\n" +
                "[\"Ows\",\"efs\",16]\n" +
                "[\"tcJ\",\"Kdc\",16]\n" +
                "[\"teq\",\"wMH\",16]\n" +
                "[\"Lfe\",\"tcJ\",17]\n" +
                "[\"sHI\",\"ZqG\",19]\n" +
                "[\"OrH\",\"Kdc\",21]\n" +
                "[\"uJd\",\"wGe\",21]\n" +
                "[\"bGe\",\"xYp\",22]\n" +
                "[\"GXM\",\"MIp\",23]\n" +
                "[\"Gcx\",\"efs\",25]\n" +
                "[\"xLY\",\"HXe\",25]\n" +
                "[\"fYZ\",\"KfY\",27]\n" +
                "[\"xqH\",\"wOc\",27]\n" +
                "[\"wGe\",\"Kdc\",29]\n" +
                "[\"xqH\",\"wMH\",31]\n" +
                "[\"MIp\",\"ZqG\",32]\n" +
                "[\"MxL\",\"uKw\",32]\n" +
                "[\"wOc\",\"Ltf\",34]\n" +
                "[\"Oft\",\"wcf\",37]\n" +
                "[\"MZu\",\"Gqe\",38]\n" +
                "[\"Idc\",\"MZu\",39]\n" +
                "[\"bGe\",\"qZt\",39]\n" +
                "[\"fps\",\"Lfe\",39]\n" +
                "[\"pYr\",\"Oft\",39]\n" +
                "[\"JKr\",\"brp\",40]\n" +
                "[\"MxL\",\"Gcx\",42]\n" +
                "[\"Hqx\",\"Gqe\",43]\n" +
                "[\"JKr\",\"xYp\",44]\n" +
                "[\"eIK\",\"MxL\",44]\n" +
                "[\"bGe\",\"tqL\",45]\n" +
                "[\"HaX\",\"wOc\",46]\n" +
                "[\"JIb\",\"uMG\",46]\n" +
                "[\"bGe\",\"uMG\",51]\n" +
                "[\"pYr\",\"xOK\",53]\n" +
                "[\"ZqG\",\"srJ\",54]\n" +
                "[\"IqZ\",\"wcf\",56]\n" +
                "[\"MJf\",\"rYq\",56]\n" +
                "[\"MxL\",\"dOH\",57]\n" +
                "[\"uOd\",\"Ldp\",58]\n" +
                "[\"qbx\",\"brp\",59]\n" +
                "[\"wOc\",\"ZqG\",60]\n" +
                "[\"Lfe\",\"Oft\",61]\n" +
                "[\"ceH\",\"KMc\",61]\n" +
                "[\"sJa\",\"uJd\",63]\n" +
                "[\"xfG\",\"wMa\",65]\n" +
                "[\"uwt\",\"eZY\",66]\n" +
                "[\"dpw\",\"Xrp\",67]\n" +
                "[\"xLY\",\"MxL\",69]\n" +
                "[\"uKw\",\"pOq\",71]\n" +
                "[\"xfG\",\"tqL\",74]\n" +
                "[\"bYs\",\"xYp\",75]\n" +
                "[\"qfa\",\"Hqx\",75]\n" +
                "[\"Hqx\",\"KfY\",81]\n" +
                "[\"Lsp\",\"ZXI\",82]\n" +
                "[\"uJd\",\"ZJf\",82]\n" +
                "[\"wtx\",\"ZXI\",82]\n" +
                "[\"cpu\",\"cad\",85]\n" +
                "[\"JMK\",\"Ows\",86]\n" +
                "[\"uwt\",\"xYL\",90]\n" +
                "[\"ceH\",\"Gcx\",91]\n" +
                "[\"fps\",\"wfI\",91]\n" +
                "[\"Geb\",\"Gfp\",93]\n" +
                "[\"cad\",\"srJ\",94]\n" +
                "[\"Gqe\",\"Gfp\",110]\n" +
                "[\"wbZ\",\"wOc\",111]\n" +
                "[\"cZr\",\"qZt\",131]\n" +
                "[\"YIO\",\"sXI\",144]\n" +
                "[\"ZfH\",\"brp\",147]\n" +
                "[\"pOq\",\"Ldp\",154]\n" +
                "[\"GMK\",\"uwt\",157]\n" +
                "[\"ubI\",\"uOd\",160]\n" +
                "[\"Hdq\",\"dpw\",161]\n" +
                "[\"pwa\",\"wfI\",167]";

        char[] mine = myAnswer.toCharArray();
        char[] correct = trueAnswer.toCharArray();

        System.out.println("myAnswer length:" + myAnswer.length());
        System.out.println("trueAnswer length:" + trueAnswer.length());

        for (int i=0;i<myAnswer.length();i++) {
            if (mine[i] != correct[i]) {
                mine[i] = '!';
            }
        }

        System.out.println(String.valueOf(mine));

    }
}
