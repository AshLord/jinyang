package org.java.practice.lintcode;

import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by 晋阳 on 2018/1/7.
 * 最多有k个不同字符的最长子字符串
 * 样例
 * 例如，给定 s = "" , k = 3,
 * T 是 "eceb"，长度为 4.
 */
public class LongestSubstringDistinct {

    public static void main(String[] args) {
        String s = "ecebac";
        int k = 3;
        //长度为39
        String s1 = "eqgkcwGFvjjmxutystqdfhuMblWbylgjxsxgnoh";
        int k1 = 16;
        String s2 = "nfhiexxjrtvpfhkrxcutexxcodfioburrtjefrgwrnqtyzelvtpvwdvvpsbudwtiryqzzy";
        int k2 = 25;
        String s3 = "wrkqgvpofmvsltijblylbspcuucoczkoeysmrilkghfzwbnprilkdrngttztgtrwzlgxtlvyxqkilwvexpeflammoybrlfuumsakwraaemqoefuulkzmbmwjrzcvpxpdvygrlskgkukelcnxftvcdvakfeakprartdkjvewaaymhkhqhehwpoqjyfbqvcethmakwcvqoadqerocckbtrpvolbdcadlbcdgrxvrmadqtlqhrpugqbluuzgheicjoytthatftamtwllicybspagkevlyophelmfkyjgzyrijjvkkicmrrwefyoiwvadjcysjnnpxyxdzhzqpfjjfzgsuhhwtwmskuxbjqbhtikfkxjpwjdrrcifmxrdzzdqqbncevbhpmjggujxsxryostbolkahswctwtraycbxykuhlxcyoksutqxpcaopiwvvzpyzlihpdjpvhufatwxqllzymzymdskicbtbcuhjqdmeirhmspwzinbqcvzluiqtyeyjnovwlzzaznsyzeadiojokfholrlswdjuyzonajzmxncwjkykqnzkoraicqduvqvgiuhmhiizmulgajtauyuvbyxlyiybfjqwixlffsvkcyqqhcexwepyrzbimmyyvyxaynudopoxssoizxqzfbypoxzjrbyouomondcryvnzozonitfombyvmvtacndbswabqutywebiqqpjzeumssdooetwaocsvrbfvwnhchcpylonvscaqksfvefqbqsnzbsujtrsxwmehrdrhwmbdvmpqqrtndeyejmqajmbxscgxlnodbhewctfymuwagtksmzpiuvchtgrjpotbxpudpzetylvulwcbdudybybpjcvnhwvblgypnuzypqihjkcznhsjbvnonydvwwagvftbenvhxqebfcrcfynruvrqcrbmorbkonyrriuubdcyokhmhjaayjwziaslgfkbuccfwsqkgnqkwxfythczbvfaanaubwdefibvhcntnzsdaoofkfdrxsiseeafsejurayrovvypwihzguqqjctkcxuzfvurippynokvlxxweugpjvlykwchcmnfozlurjkwwihmwrbmyxscvwjarfifycnajhdrflurhijujodxpjlsovculjlcuihvsxewtgrmkobtapzzsrglwkshudbganseglmzqlqxfowlppjlatfszqymgnywrxomnechpofhbsqvqnegkakdkwhrellqodpbsxhjykzdrqyjxsaqjzklppxvumcnwpzwjdppxzzjbtjkelewhaqntwnmjlcepmivzonszvrbsgycclpfuweapbpnaugwywffjumqxafwkssihqpkxjbjnvmwyipiizthxxniclcxkjnbseffjvgeeltkajpqyswrgvjcsqmxoiaaxrfvqaiuczbyuffnbufydczumrxvlmuaxebegqfcxaegmgmbinatvxoyrflmvsodlatvjbrpbwxnurpkdzhclkmsibscnpycudrefeirebitlskmwuelzebjmjyyhstubtljemfwybjmijfxexbuutrhjewrrzyydlxnmqidhmdabjawpdajbaqlynpqupoadmzbryigjicanuzeeoqmkgajvpjphmvcwflcitvtyekbtunnwayrwgbyksjopilbsiiwdcuzvmcghhluovahsrfbvpqyktmnprgzhdcevbwicwfirxqgtedlvqxivxosrfawlvlrltwpahazwattwqdlgruerrdmfrjtjfsaayinyrngzfbiiiwfddnppmmvzvakmwulikvftqflrbxvgujcwfcgszgugqpqokywvpwpnmhpgnvshtofdvsprcertahayfeebbxfrgndvutruhgvtlzdkfgyaqwatjtrdtpftpyxlxqwroknsbxbstnkzdssraiehrxynqztfescxvoyextbisarbtvhenwzdrmaozuiftoijmhhcgkplvhvmyrlxyoughnyadattlcgnltehbgferdvohedcbilynxvwflhjobamzcuzrclpoiwycpjstcvxgzatqyghxxfeszxfrihqyrtwmbzhyxqupswhzhwdqihbhhusrtyxmktyegqrgjkhceqotstnycmznpdybcggypvzbkxswljslozpgpvforskdkyoiaqghvocoahtvouxuiiuzywxoxnldzrnxlsqrovrlqysslcurazkrqgboqoylhtiqyollmoybgopxwzwbklewwaymfkbwqxzgmvjlhcigbdmmobvvkadoqdvjbvibqcifsoybzvzuyxhvefayqdumbgdnerzefmdbubpzqdjaajyqfojosgtdubznphaxlnbburvdholtttieqrirtrgyluyuouijgshcqsadouufyizvkcnrlyyygqljkbczckhwgjvjfdqnecdrkuljzzfnrvavccvbcchjxmxctgdhclpkndfhvkecjodcitdvcbffzttiykokykyoknwyotulvbuziobdlgpmajshfnqeasnntonnttpzykgrnxzwaqlhthekydgwxrvvkqixfhzpqcnkhahmdeirpratigafkknahyrekuwxipypahhvrfilibprzynmsbmzgwjbbxofbsfhizoiqrghxyzpihsyixptixdudmqfijbepkwgraxmpvycpzgjuywdjjwgwdqjdohdzochlpxfjhvhrjwdqtjciirpkdlkqsmfpfkieunojlzzjmbbuzpbjfwpqbogmldxalcbcxspgeqbnausghkfagpitzzoriobxotdmokpgyfhbcjrjqnbykjnmoxnlhhjibgapqygumodhwbrevomawldttymvduvbmjtuvlaxksmxrgzmjddjeeepbgruhnoqwhfcdkkwkqzqeotoofjnmwhejsjzqdhsdnwlprqeuyzinbafuooywuikktlbhwevxisybpkwocwfnyabxoqdesdwhecvcqjrehvyaoksysspdvcezzcvrjxijlanwptpvceecuohiplozpkwpzouadzutkvkhopqjebujngjtlsblxhvobbcgyedaucxdqicqvlrmnfbbbfcfgmjzvchszwmjfzzzidldrqngwdzrbxufkjjcgsdvyjjytveadkwhuzzliqlbqxjzpoilrzddexpmvtzwiulpxlnidnnhixznvcrgzwywepvbvulnbuhndojekieuvtvckvrrqgoeyglsqwubmdjbycpwwpsszsuyzyugtpzuhessehdptzomvcspnrxscvrljtogipbztjmrrihfrygtpnamnndaimknzngzajmcbaivwstgrjwsdhckfqgqhnylhpzhwvqcswbvicrzkqafjskipzahuxcxiocgxicfwpambkbxfffimjmsplgidwohfkarehhzwtvgwcxblqzgjtohmwezkdahdwbowvukckqoflwatnmevomchnlucdeqpeadxhoqvdmdncbsqugfemovbmrsuoqqlfqvsceeyxuvqqnrtbmsdxlumcavtdmqdszpjkcjkiljpjnvgixdldouakogjwisozycbpwhsfzlhwhoilpwrbcakhfbutgthvmszmzsdmhhjckzxwjvdfbzyjgsevcpoxzsmjcbukgmqcazesimfiarqcvpfvrylbjpppvsgmpxssmqknhbtwjufyrwgmyetioxocgmclvzgavvcglqyfsisaroqueagprpfkobtyjsvmnjyudovvmajyyurvilldkgypbwszadxvhvjunrjupsyfetyrsnkifppsceydogyayjgttsbwmnrsolanrlxavpqbfhgnvhydxvifwouapimywgszctdetgzdvacgzlsctftipooeoujrbcbyjlxachmcnuuyealtwmnjztkjchsffmvtcgwgyvmfvqnwxxqmstpxsoawtlpvgnnjaaatqfreqexjqfggfbrqqadmvwfikqfvimfiihuxiephcmgieqlguungaewsmzrwlzkkuydwoarsgjcqdyibmleitnffejspusrlqrztinscxlbqhtyjqcsbmattazuirldpjrhyqtajarzvdwfpugytxufwndephhbywkrzpplhhzptvyghmtgixxctwinmcqvbdsbofwqkxhrhhpukiqxajthzewojezckkscflchmdhcvbmnewwwpjvkttxglxzolwwykwjifehzfvxljxhygjclxoiyadmiujxppsepqjnomrqwdfuwdqufijqaevyjwiqxqegdyiikrtepychwueojpvbbqhfcbcymdursvuwhhpdplfzgqmgsrkmdcgljrdplqtnfcyevcblbxdfecujkhilvfxnguemgysvyygrdudywuskcneapezsngjbfdvrxwzclnljifatjfokpredgmvugxhaoopdgvzwfhpqafwpetprslinxmdpmdnjttazqxpxmxbkjihozoevkijfkzmilxohiabzjevvzyflifzrkmrvffxpbiunzwgwvwwatflsrqlisgjlqwflihnlcwcgubfkquchhpdrghttnhokabdtvehshzikxulmfuijmttrhirqxqonfsindhaxjqinvbjyzdlzqcqhkfgzfxifreorpnzoicrevieoxqyceagnucncvbcfahdcfkamsivklusagwtlknabxdrywgwtodtaxchnsxawcbrkegboitclkitlmrhqzbwfwbvekxknnjoirnoespbcomkshwozefwazqwgacqfpurnnbffhiehqgjofvtaqxhomjmvumqxfsbyqkvjrlohxcnsryagfsjncsbjojtwhsghqhmijdmqcfidntkqwcejeiestwlsykjguuvdarkuzhukcfhtxrjfydtipyjcubrflkjtbmvejewqbwuqhgalkqlnmqklvmxocsehmbtgqfcwlpbublserzcqdncjbdqrsaaqwskafepzjzoephohluaastcalplzuubzolyjyzpfmlahxsiopyuwejfwhazumuddkaltlyejtpxoltdoijsrrvjcxsfucvkwvbqusacoxcxadvmqzklsiomjhgwqhxclsfmssrrviufaiqwiqqtqlehjnolknsdzidtlixhblqyasufptpliosijhmyoilwvefnoptrtvkrzqpcofngcmnszimybwopaaygojqiidpzwykgsflswwptnbymjayeyebcbuougdthnkiuseheljzgfutlpheceqtmycbmobncvgrownbkedwosbyitwgmuexuemtqhtdgavwhdqypenzhkilvgezzrukxfpaxdyvbyqbqdqclbrppdtanndohoubjeralxljopssprfrpicylsvcifkauqbhiwjxcgiovxectxhiusomkjmrcninttpsjtoyointbvwvtsszcxzrfmykcznkyoglouxzpakiclmkzvzaqikobijyhpeodfoxkckzvcdkorqihbabxsorboxlkctfppldlhmugvvojrsffazdvusyhxoqpqsrcjqtbgeycknbvutudqhkabtqldugekqisyjfujtwcefsrpbmvowywmjicdduwirwruapslcibskriceuevvsnfxnyovslserwblrsjvvfpolxgwrhajymadnhxrofmophhkgglcfyizigxpmtsyzwrpsuahqctiknngdflvmquwdqdefpbdxbgngiyujqybvszctabxviuhpuhihhifutyhwbhxrlhriuaoqezyqpcejourrrjshfehumxxzhztpxbdtvvlzhcsivgttnxuxpmbowurnewmverwclispkxetokvxaprssodxpnjavpzutlxyxsbolfbcgfbpskvpqjczlaxuolswuwmvwobpusicpttafvxuwljpriiotjdhkmdlwnkxuotvmtdujwoucstzurhsutdsbkcqklbdlzxkfrizozrgnajlbmissesghbefpnpjgvftlqriwbkwsdgervaqlinhvcvuzainkkivihvalparcmypryrujeexpnfcsbgdpysidukdoqsialvvregxuqwodwnalcjbesypkpekcmocsqyvglcmjqdispdyxzdmrivjhojshewdjbnxxfowahwzbxoozurradgtxncquvkztnohfnekpvedfwdwefxondtsylzvdrnydcrbfseovmbvjmarwoibfzsbwyswjtjnerhxhkqiqqkzwcxrczhyovphsdqmlcoswyuxfiqwmhjjjuykdolfmtrtpksfrzvgoqdotwkwecqovqwlslgvmawjkfrhxvfberrwrfgdahtolrrmatodsnrcprxmfwmvkzedyqqibgmzvlxjmzhyxzfvktksxinraxatggnnwduguxkqgiwnspnptwdcxqyygbiyqfetgfzpgywkxcokbjhihzthouqsnlgjfdqxtbumochckifqnwodbaunexukjhhgoaodkohnyxdwvxtstzjofortzlrdgihynnqqjxmfufhxmnjekinjfylaqxtzlghudbdhfxnkhjyhoqhhivptadxmoiyoebnxlajvppctabxknjqekrcbzqufwynqikdfngnkwpnfmblgivfnrqlewjvkqcgdymkrwjwslsmwltwdzygzbtpckfisatpswveadpauxupqihxtupjcrfnpzytkacwlvrhuqbylybzoiqonkxvgnbqeggzosfpgepnohfqrusnbmuhazoqofzdynsvdnztaswblvyufsdxfydjzulubzvdpivjvmoyfemekiksoorbnupazajogzvhwppfutfqicigsnjobdmlmazxeebtzmykioizkhcqqfynykvcrdjztzzpeguwzbywvusesyjxdfauashjttctnyfgxxwvgxglqywfvokibysslmiglzwmkjoqcahpuptwsllhwaplpnuagxcvevcjaartgjaoqyuqihyfvchuufkdiswzyqgfokqabxcbyhfuebapcwndihpaqubdhxsrrddrppugillicdnfjsuxhwducsiuwydnqqwmkvahvxtlfxybgffapmvythbaemsvdqzregkgcfviotebunevoipwpztooidtkmgdxgmeimdofsydcdpfamvoctilhdmopepebqdbcdajkhqpfbicjdfodwdskwpjvmabzfhrfxlyfxtfypptrhkkduapchhepycugdlbqsqjlrazczmueysykgjksmrumjlvjdiqkmqxqusevjfofrdlkerluywwvtmwqgyvyrhpkwzmuaztkzeeoemmhymzfuwcapamiygqzbawecxibvyadeqiaiawofaxbgaphskdiblzqkznbfitxiefvushifgzsqqqqgwantcannpcotumqgobttdlgyivpiosxvhcgusaksflwfqxnwighobpkxnimbcfdbnswvpbhdzpikickgwqqnwbmczlzeposdieilpdngtxwktnxqgfegdlhbtcpwbwzylzxcazpgjltqrhczkcpevxseqesykchzhtvecgmtiwcmeamtzmlpzrwjxsmnnqwlgeybacheommkkgpoeohzjulrmwookjjgrnfsugbaphxdekzwdtpbnatercbiusqljnebxwlkrevoxhzsgzzhlrbcxnisnzlnybtiltrfszdmxaageajgxhqdhiznfgvnlmobzondxcsyzzbdtrjgpczexoxibzzojsarxdecelhxidkkabmpdglwlrmsvehmfquhlksrixygdrlzeopluzbxinolhcsaxfnypokagxhqbdoxdbpndsobhpfozjvtpzswrcmjsjconwmvegqzppryfjcmdslvwrdequpowihihyhstoqjvgucdorlkccuanklfbjeakhfnxrybrjbeiwgbjadzdsjnrkpilpnwjqgcdarrhkpstwfvzqguryjvjakefnmjyiycpgeeynqtplenaiubbhghutyofsiihidhjorcyqzimipbcqqdxvtetszizqzvxcfqkdoejtlinmdsuvpievtlmktxwjwkzgonphxquldpprehmkpwthbmjvlitoczirwbuobmkiilohtigpkctvpdniqdiqovfqmhdyffxcqsypnjwyrhgmntgdcwzlpwpxnuvozuegeqneryuaesniyvfqyacavqdujnjzrqlnqjouqdqhtbscmvqadkyggjexcotcjqqdrmynsilyzjselwzleguimndejrovhovvajurnyfsfuqxuplfqxadrtwuaintcwrsvlhnxvdrrpdubumbmodjaksldpumbriuyptpnrpdohohvuplrnsiwoxyygrddwrhvqfousaxxzdiqhewgjftjbkuvplnmazozcjmykluktgbghcufyyqqovmjkhnrvqqkdwwfpxoagdmcofskpjwdsmmidgilbgnevedmpuxevoxuaxquqtuyshlzccxxsjlxbrenzuyyyoapfuebtzsqhtrowsqjkqqtagtvyxdylazbtvfbhifmiiyvycxbevgjchvihdrtrjouoydzuoedyueduppduxynrobbchvnrdgmfpcdgcoldpjichrtdqelvrspvwbdzsdfltpuvbzzqptnbzxgmslsrqqigdfhrjuiuuiuldruwppndexbvzcocexcuaqfmecxirkogtpzkgltpaslossficovwakbnsmlxtseuveuhqkuruytuksfbhljtymraersgmhpncxgauvodaeflqnpdodtzsmjbulshjwgraxmhjxrvbprilltlhmnxnmdnyuvckfjjydvjpoojcutugczbjhdfyvzlvrgjrndpsxxftegbfjzbyrymprrhhvkmutwtbwqzhqslssbquswzrdclbznkcnycunyjamechlloqtbnoawegobvxigakvonstaboyysrwbrnauvrcsnkaqyzkwubjzxflqxsivbjdoeltagtihyrsxgwuicmkjovcsjtapepfdooowptgftallmrbprjcjpxgmdsrzzrqduzikqwaljuwrucbodstvpwfdplaxxdbqauxgcwwmzwnyjlublbtdkzxmcnsekhsuvyoighkiyhevbtlfgsdppnzlnyvschzizxfynjbprbrvmzcpszoecghrscmqwpbiayntkbqaiuicyjlkbhgwbbkiqbjmiqijotszqnumcvaqgoikzdpihkyrspxzsrtniapektnperzkluwjdyetionwspvufphtkpsoirjdqhuqyikcdjlqgibvnuwleqazvlnhqkmrgpcmhctsbthsorrpknhvfhcwskazrquvrualqxnzphcslzynulvuemmhsspbdkshjyzxtyiafgmrfqlqultbkozpufxywpxdbnuhhrrvwyplecqzedepklngdbhzqoupylosazbttilceefpqqhspdmpfzjovpwbgpuirkrnayykcnmtsxvtaxjxlpbynqemlhwwxmadpldtyhixwwfynyremzkxjegddfjdxpmznaoydhibdrhtqzlibbcbzdmpwkanjtjynnrabcdmbkdhsbkkeikmgwpotnocjbqpfnzyegbybtekgnpfcdpyguvnbpqiuvtkqencnxhccxebujaxkzmvpqdypdfueoxcoyydhzlduwbpqbafqvmzcmouuolbzvmmblnfzfftrmttkadwyakobqdzrffxnaffbbxupzudnmrzcbaazjfwyoqzcbfmtqhnreihyyqeyglijiofkjwjslbhmhyczftpcfaymhvpdfmhkaddhcrpxadgpbboywqbanckidflolrxnuynvytupnxqxyixrnrmqdogevbputemmfbvrdrkydurcjguigwxishwbulesrtphjsizksigfagrrztqqgzhtegynwebeqdoximyvzpbueocehtymzbpoxdqqjohnkqlunperyslziroljivkojwtwobzdxcphkrlqmcwzunsbmplviurkmrbecvzwjscxurypzrjxkhuxzycvlfztjflqxnxfrnjrxdkggitxudfyggedquxedovfmayfimbsygdovluofmxqvuotmvzqdccorpmzlcywyculzdzwdalvhjgihnptvpdiwjrrmybtzigqflrudtrkgyafwczagqvkxjzpekunjdbsjmhrsdbckiyglkvxwwdbmxpkuycwgqiskzweysmyljqcgrajzibgjhenvxovlomncmeskgqqcmroorvyhlvxpmfldshmrmpeczcrrmkrtwjiesyemilghvlvfxnekkoutpegqxrrpaeuvnmuahiwowkggjyfysffffiqewvwwhqyyewzidluwklqcwbxjmsywgcgtxwbzrsrrxeikvwmhozdoexgszxwskoytxrqtbzvzecnkeivniqphhiamlpvhvmwcaswxffqceujxjdwuekgjqnkliwnaywwhapeeudkpbhcxgqjnbzplczecnmsbmhlgeopnxchgqbkpapxthzqojdbcnybknkmekkddxqrcujjsrqpqjjkzhjwrapwavojtrjtioxqidwldodjyibgkizwzjyolhubsdkjipidbylclyvcrcpnkoxiorjhuhrsmslarnngxmdzpfwquvwqaimujiqkiepkmjoxcgfcrxhhbqqxxxbcuoswfxzjckiaplohbpexilsskasxjyphjgpdkkskseyjuvyskrsphhtiavmmlogdkcnkkptndeqoffblhcumsmfofmsdkdjoixwulvqmuprhsxxddystqdjfzmhzlzpwspumlyzeqlzmsmgteybgkbqpvftnqjxhbwrqjalrxdrrvmeqdteaaocaaycftgxzkwqhxnlcsncduhjljtpeeohebizjupiucpyuylysyapyozqxkivbmctdgvpzdjsfpacscmsdfbkxfcncqddwtybcfrzqicwvsrupxdxoxzuezymfgtkbasnllgqpjqmmtiashfobzwoexicupfsdxvhtmtjgvlbwyvgxtiyyfzrvrjvnknlfzjubmqkgbiqlktypiglvmrtoaegzatptgndbiwnykmmqcxvddfhmptellmbfptnqbloxrkfxdrslyhuwmdisncpbkvwynfypnyoajimxotcxiudfsvftkdbemchunjddhpwzlllzfbnuxbhxsuaegczbofxyaricdbbzettoawrdgapfzghwixpjwikiilffglmcmtbjhnjepcsvsrwgkrnxkuhdwcyhercgyscihpgvmixqxrblhbixdsvpaxqboflgncekbvogbaxfcujhmlmsphvljwxkklpyaookfjhmxdierrreafcbysbhluepfaezkmrqgukjmeivguxaqaeibpyrfnpzdnqowwiintlluxigkaptnobvsremmhkvzbpglvaecncpsvyuaspbacxmgbjayazlecgbhpemrydymbbsosezazfqsjnhendxygjwummwzdtmbndbgmgutnoiixabnudtisrlytbwokvisvrqqiaislihighlxmivpistnkzhfzjqxbpxperuqrfsxgdojlujndogifnsfmazzrydwcliiwiooiixwzugupvdedqqukmalvslybprerjuoswsjgppckygnzcoqitdigpzvsdvpmgdxgdxqijyfflrwsrhpizhwlmjvtotslmoasrjnoultypnmogabredlpovkekillzqhxydzuacmjdxxqplracvcksgugccwjmhdsoffnvbjnecrsitwtmqgvkhdvzmbbiaojryrqiskjhzaxycdiuavirvgvejgjegxszxxttpurpvbyeelsrziawrvytvdmjqpcknzssnitiwiocrelurwftsvkuyyjbjpfxtrnieidrqkxncxyhyefpnpgypwkjcytwxkyfnaalxiqpooxzpbgbqkrexxvfljutqgaqxbasjkmzdsngrrphdjgfuazjlsgomjblojcmbbvzxmwasljhxznsbbyvnjzlqaf";
        int k3 = 1;
        String s4 = "kb";
        int k4 = 10;
        //符合结果的子串为 eceb 长度为4
        switch (2) {
            case 0:
                // 循环递归，在大量创建递归方法的栈帧时候，使用HashSet会造成栈溢出StackOverFlow
                System.out.println(longestSubstringDistinct(s1, k1));
                break;
            case 1:
                // 尝试用循环来替代递归
                System.out.println(lengthOfLongestSubstringKDistinct(s4,k4));
                break;
            case 2:
                // 采用双指针，用map记录双指针中间的字符串是否满足要求
                System.out.println(lengthOfLongestSubstringKDistinct2(s,k));
                break;
            case 3:
                break;
            default:
                return;
        }
    }

    public static int lengthOfLongestSubstringKDistinct2(String s, int k) {
        // write your code here
        int result = 0;
        int left = 0;
        //声明一个HashMap，用来存储k Distinct，还可以根据value用来判断元素是否可以删除
        HashMap<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            //右指针依次把字符串中的字符放到map中
            map.put(s.charAt(right),right);
            //当map元素大于k Distinct时，得到满足要求的子字符串
            while (map.size() > k) {
                // 删除最左的字符，删除成功，则退出循环
                char leftChar = s.charAt(left);
                if (map.get(leftChar) == left) {
                    map.remove(leftChar);
                }
                // 左指针右移
                left++;
            }
            //子结果即左右指针之间的长度
            int subResult = right - left + 1;
            //结果取最大
            result = Math.max(result,subResult);
        }
        return result;
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        //边界，当查找就剩最后k个字符或更少的时候，最长子串长度为当前长度
        if (s.length() <= k) return s.length();
        int result = 0;
        for (int i = 0; i < s.length() - k; i++) {
            int p = 0;
            String subS = s.substring(i, s.length());
            //创建一个HashSet，仅存储k个不同的字符
            HashSet<Character> kDinstinct = new HashSet<>();
            while (p < subS.length()) {
                //在HashSet中存储k个字符，超过的抛弃掉
                if (kDinstinct.size() < k) {
                    kDinstinct.add(subS.charAt(p));
                }
                //检查k个不同字符中是否包含当前字符
                if (kDinstinct.contains(subS.charAt(p))) {
                    p++;
                } else {
                    break;
                }
            }
            result = Math.max(result, p);
        }
        return result;
    }

    public static int longestSubstringDistinct(String s, int k) {
        // write your code here
        //边界，当查找就剩最后k个字符或更少的时候，最长子串长度为当前长度
        if (s.length() <= k) return s.length();
        //分成两个子问题

        //第一个子问题：如果从当前字符串从头开始找，求最长k不同子串长度
        //创建一个HashSet，仅存储k个不同的字符
        HashSet<Character> kDinstinct = new HashSet<>();
        int p = 0;
        while (p < s.length()) {
            //在HashSet中存储k个字符，超过的抛弃掉
            if (kDinstinct.size() < k) {
                kDinstinct.add(s.charAt(p));
            }
            //检查k个不同字符中是否包含当前字符
            if (kDinstinct.contains(s.charAt(p))) {
                p++;
            } else {
                break;
            }
        }
        System.out.println(p);
        //第二个子问题：如果从当前下一个index找，求最长k不同子串长度
        int subLength = longestSubstringDistinct(s.substring(1, s.length()), k);

        //开始收集子问题的结果
        return Math.max(subLength,p);
    }

}
