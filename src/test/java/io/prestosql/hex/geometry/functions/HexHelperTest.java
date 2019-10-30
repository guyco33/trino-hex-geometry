package io.prestosql.hex.geometry.functions;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HexHelperTest {

    @Test
    public void testHexCover() {
        String polygon = "POLYGON(( 30.145345097851646 59.98696259433687,30.057454472851646 59.997951427400594,30.00389612324227 60.00001142735134,29.99016321308602 60.01374148244775,29.99840295917977 60.12200867673294,30.29228723652352 60.11858794208799,30.293660527539146 60.07888143623337,30.15770471699227 60.03638361339914,30.145345097851646 59.98696259433687))";
        Long[] expected = {60872039L,60872045L,60872047L,60872133L,60872135L,60872141L,60872143L,60872165L,60872167L,60872173L,60872175L,60872517L,60872519L,60872525L,60872527L,60872549L,60872551L,60872026L,60872048L,60872050L,60872056L,60872058L,60872144L,60872146L,60872152L,60872154L,60872176L,60872178L,60872184L,60872186L,60872528L,60872530L,60872536L,60872538L,60872560L,60872562L,60872568L,60872570L,60872656L,60872658L,60872664L,60872666L,60872688L,60872690L,60872696L,60872698L,60874064L,60874066L,60872019L,60872025L,60872027L,60872049L,60872051L,60872057L,60872059L,60872145L,60872147L,60872153L,60872155L,60872177L,60872179L,60872185L,60872187L,60872529L,60872531L,60872537L,60872539L,60872561L,60872563L,60872569L,60872571L,60872657L,60872659L,60872665L,60872667L,60872689L,60872691L,60872697L,60872699L,60874065L,60872022L,60872028L,60872030L,60872052L,60872054L,60872060L,60872062L,60872148L,60872150L,60872156L,60872158L,60872180L,60872182L,60872188L,60872190L,60872532L,60872534L,60872540L,60872542L,60872564L,60872566L,60872572L,60872574L,60872660L,60872662L,60872668L,60872670L,60872692L,60872694L,60872700L,60872702L,60874068L,60872021L,60872023L,60872029L,60872031L,60872053L,60872055L,60872061L,60872063L,60872149L,60872151L,60872157L,60872159L,60872181L,60872183L,60872189L,60872191L,60872533L,60872535L,60872541L,60872543L,60872565L,60872567L,60872573L,60872575L,60872661L,60872663L,60872669L,60872671L,60872693L,60872695L,60872701L,60872703L,60915712L,60915714L,60915720L,60915722L,60915744L,60915746L,60915752L,60915754L,60915840L,60915842L,60915848L,60915850L,60915872L,60915874L,60915880L,60915882L,60916224L,60916226L,60916232L,60916234L,60916256L,60916258L,60916264L,60916266L,60916352L,60916354L,60916360L,60916362L,60916384L,60916386L,60916392L,60893867L,60915713L,60915715L,60915721L,60915723L,60915745L,60915747L,60915753L,60915755L,60915841L,60915843L,60915849L,60915851L,60915873L,60915875L,60915881L,60915883L,60916225L,60916227L,60916233L,60916235L,60916257L,60916259L,60916265L,60916267L,60916353L,60916355L,60916361L,60916363L,60916385L,60916387L,60916393L,60893870L,60915716L,60915718L,60915724L,60915726L,60915748L,60915750L,60915756L,60915758L,60915844L,60915846L,60915852L,60915854L,60915876L,60915878L,60915884L,60915886L,60916228L,60916230L,60916236L,60916238L,60916260L,60916262L,60916268L,60916270L,60916356L,60916358L,60916364L,60916366L,60916388L,60916390L,60893869L,60893871L,60915717L,60915719L,60915725L,60915727L,60915749L,60915751L,60915757L,60915759L,60915845L,60915847L,60915853L,60915855L,60915877L,60915879L,60915885L,60915887L,60916229L,60916231L,60916237L,60916239L,60916261L,60916263L,60916269L,60916271L,60916357L,60916359L,60916365L,60916367L,60916389L,60916391L,60893874L,60893880L,60893882L,60915728L,60915730L,60915736L,60915738L,60915760L,60915762L,60915768L,60915770L,60915856L,60915858L,60915864L,60915866L,60915888L,60915890L,60915896L,60915898L,60916240L,60916242L,60916248L,60916250L,60916272L,60916274L,60916280L,60916282L,60916368L,60916370L,60916376L,60916378L,60916400L,60893875L,60893881L,60893883L,60915729L,60915731L,60915737L,60915739L,60915761L,60915763L,60915769L,60915771L,60915857L,60915859L,60915865L,60915867L,60915889L,60915891L,60915897L,60915899L,60916241L,60916243L,60916249L,60916251L,60916273L,60916275L,60916281L,60916283L,60916369L,60916371L,60916377L,60916379L,60916401L,60893876L,60893878L,60893884L,60893886L,60915732L,60915734L,60915740L,60915742L,60915764L,60915766L,60915772L,60915774L,60915860L,60915862L,60915868L,60915870L,60915892L,60915894L,60915900L,60915902L,60916244L,60916246L,60916252L,60916254L,60916276L,60916278L,60916284L,60916286L,60916372L,60916374L,60916380L,60916382L,60893855L,60893877L,60893879L,60893885L,60893887L,60915733L,60915735L,60915741L,60915743L,60915765L,60915767L,60915773L,60915775L,60915861L,60915863L,60915869L,60915871L,60915893L,60915895L,60915901L,60915903L,60916245L,60916247L,60916253L,60916255L,60916277L,60916279L,60916285L,60916287L,60916373L,60916375L,60916381L,60916383L,60893898L,60893920L,60893922L,60893928L,60893930L,60915776L,60915778L,60915784L,60915786L,60915808L,60915810L,60915816L,60915818L,60915904L,60915906L,60915912L,60915914L,60915936L,60915938L,60915944L,60915946L,60916288L,60916290L,60916296L,60916298L,60916320L,60916322L,60916328L,60916330L,60916416L,60916418L,60916424L,60893897L,60893899L,60893921L,60893923L,60893929L,60893931L,60915777L,60915779L,60915785L,60915787L,60915809L,60915811L,60915817L,60915819L,60915905L,60915907L,60915913L,60915915L,60915937L,60915939L,60915945L,60915947L,60916289L,60916291L,60916297L,60916299L,60916321L,60916323L,60916329L,60916331L,60916417L,60916419L,60916425L,60893894L,60893900L,60893902L,60893924L,60893926L,60893932L,60893934L,60915780L,60915782L,60915788L,60915790L,60915812L,60915814L,60915820L,60915822L,60915908L,60915910L,60915916L,60915918L,60915940L,60915942L,60915948L,60915950L,60916292L,60916294L,60916300L,60916302L,60916324L,60916326L,60916332L,60916334L,60916420L,60916422L,60893893L,60893895L,60893901L,60893903L,60893925L,60893927L,60893933L,60893935L,60915781L,60915783L,60915789L,60915791L,60915813L,60915815L,60915821L,60915823L,60915909L,60915911L,60915917L,60915919L,60915941L,60915943L,60915949L,60915951L,60916293L,60916295L,60916301L,60916303L,60916325L,60916327L,60916333L,60916335L,60916421L,60916423L,60893904L,60893906L,60893912L,60893914L,60893936L,60893938L,60893944L,60893946L,60915792L,60915794L,60915800L,60915802L,60915824L,60915826L,60915832L,60915834L,60915920L,60915922L,60915928L,60915930L,60915952L,60915954L,60915960L,60915962L,60916304L,60916306L,60916312L,60916314L,60916336L,60916338L,60916344L,60916346L,60916432L,60893819L,60893905L,60893907L,60893913L,60893915L,60893937L,60893939L,60893945L,60893947L,60915793L,60915795L,60915801L,60915803L,60915825L,60915827L,60915833L,60915835L,60915921L,60915923L,60915929L,60915931L,60915953L,60915955L,60915961L,60915963L,60916305L,60916307L,60916313L,60916315L,60916337L,60916339L,60916345L,60916347L,60916433L,60893820L,60893822L,60893908L,60893910L,60893916L,60893918L,60893940L,60893942L,60893948L,60893950L,60915796L,60915798L,60915804L,60915806L,60915828L,60915830L,60915836L,60915838L,60915924L,60915926L,60915932L,60915934L,60915956L,60915958L,60915964L,60915966L,60916308L,60916310L,60916316L,60916318L,60916340L,60916342L,60916348L,60916350L,60893821L,60893823L,60893909L,60893911L,60893917L,60893919L,60893941L,60893943L,60893949L,60893951L,60915797L,60915799L,60915805L,60915807L,60915829L,60915831L,60915837L,60915839L,60915925L,60915927L,60915933L,60915935L,60915957L,60915959L,60915965L,60915967L,60916309L,60916311L,60916317L,60916319L,60916341L,60916343L,60916349L,60916351L,60893986L,60893992L,60893994L,60894080L,60894082L,60894088L,60894090L,60894112L,60894114L,60894120L,60894122L,60915968L,60915970L,60915976L,60915978L,60916000L,60916002L,60916008L,60916010L,60916096L,60916098L,60916104L,60916106L,60916128L,60916130L,60916136L,60916138L,60916480L,60916482L,60916488L,60916490L,60916512L,60916514L,60916520L,60893985L,60893987L,60893993L,60893995L,60894081L,60894083L,60894089L,60894091L,60894113L,60894115L,60894121L,60894123L,60915969L,60915971L,60915977L,60915979L,60916001L,60916003L,60916009L,60916011L,60916097L,60916099L,60916105L,60916107L,60916129L,60916131L,60916137L,60916139L,60916481L,60916483L,60916489L,60916491L,60916513L,60916515L,60916521L,60893988L,60893990L,60893996L,60893998L,60894084L,60894086L,60894092L,60894094L,60894116L,60894118L,60894124L,60894126L,60915972L,60915974L,60915980L,60915982L,60916004L,60916006L,60916012L,60916014L,60916100L,60916102L,60916108L,60916110L,60916132L,60916134L,60916140L,60916142L,60916484L,60916486L,60916492L,60916494L,60916516L,60916518L,60894087L,60894093L,60894095L,60894117L,60894119L,60894125L,60894127L,60915973L,60915975L,60915981L,60915983L,60916005L,60916007L,60916013L,60916015L,60916101L,60916103L,60916109L,60916111L,60916133L,60916135L,60916141L,60916143L,60916485L,60916487L,60916493L,60916495L,60916517L,60916519L,60894138L,60915984L,60915986L,60915992L,60915994L,60916016L,60916018L,60916024L,60916026L,60916112L,60916114L,60916120L,60916122L,60916144L,60916146L,60916152L,60916154L,60916496L,60916498L,60916504L,60916506L,60916528L,60894139L,60915985L,60915987L,60915993L,60915995L,60916017L,60916019L,60916025L,60916027L,60916113L,60916115L,60916121L,60916123L,60916145L,60916147L,60916153L,60916155L,60916497L,60916499L,60916505L,60916507L,60916529L,60894142L,60915988L,60915990L,60915996L,60915998L,60916020L,60916022L,60916028L,60916030L,60916116L,60916118L,60916124L,60916126L,60916148L,60916150L,60916156L,60916158L,60916500L,60916502L,60916508L,60916510L,60894143L,60915989L,60915991L,60915997L,60915999L,60916021L,60916023L,60916029L,60916031L,60916117L,60916119L,60916125L,60916127L,60916149L,60916151L,60916157L,60916159L,60916501L,60916503L,60916509L,60916511L,60894186L,60916032L,60916034L,60916040L,60916042L,60916064L,60916066L,60916072L,60916074L,60916160L,60916162L,60916168L,60916170L,60916192L,60916194L,60916200L,60916202L,60916544L,60916546L,60916552L,60894187L,60916033L,60916035L,60916041L,60916043L,60916065L,60916067L,60916073L,60916075L,60916161L,60916163L,60916169L,60916171L,60916193L,60916195L,60916201L,60916203L,60916545L,60916547L,60894190L,60916036L,60916038L,60916044L,60916046L,60916068L,60916070L,60916076L,60916078L,60916164L,60916166L,60916172L,60916174L,60916196L,60916198L,60916204L,60916206L,60916548L,60916550L,60916037L,60916039L,60916045L,60916047L,60916069L,60916071L,60916077L,60916079L,60916165L,60916167L,60916173L,60916175L,60916197L,60916199L,60916205L,60916207L,60916549L,60916048L,60916050L,60916056L,60916058L,60916080L,60916082L,60916088L,60916090L,60916176L,60916178L,60916184L,60916186L,60916208L,60916210L,60916216L,60916218L,60916560L,60916049L,60916051L,60916057L,60916059L,60916081L,60916083L,60916089L,60916091L,60916177L,60916179L,60916185L,60916187L,60916209L,60916211L,60916217L,60916219L,60916052L,60916054L,60916060L,60916062L,60916084L,60916086L,60916092L,60916094L,60916180L,60916182L,60916188L,60916190L,60916212L,60916214L,60916220L,60916222L,60916053L,60916055L,60916061L,60916063L,60916085L,60916087L,60916093L,60916095L,60916181L,60916183L,60916189L,60916191L,60916213L,60916215L,60916221L,60916736L,60916738L,60916744L,60916746L,60916768L,60916770L,60916776L,60916778L,60916864L,60916866L,60916872L,60916874L,60916896L,60916898L,60916904L,60916737L,60916739L,60916745L,60916747L,60916769L,60916771L,60916777L,60916779L,60916865L,60916867L,60916873L,60916875L,60916897L,60916899L,60916740L,60916742L,60916748L,60916750L,60916772L,60916774L,60916780L,60916782L,60916868L,60916870L,60916876L,60916878L,60916900L,60916902L,60916741L,60916743L,60916749L,60916751L,60916773L,60916775L,60916781L,60916783L,60916869L,60916871L,60916877L,60916879L,60916901L,60916752L,60916754L,60916760L,60916762L,60916784L,60916786L,60916792L,60916794L,60916880L,60916882L,60916888L,60916890L,60916912L,60916753L,60916755L,60916761L,60916763L,60916785L,60916787L,60916793L,60916795L,60916881L,60916883L,60916889L,60916891L,60916756L,60916758L,60916764L,60916766L,60916788L,60916790L,60916796L,60916798L,60916884L,60916886L,60916892L,60916894L,60916757L,60916759L,60916765L,60916767L,60916789L,60916791L,60916797L,60916799L,60916885L,60916887L,60916893L};
        assertEquals(HexHelper.hexCover(polygon, 512), expected);

        assertEquals(HexHelper.pointsFromPolygon("POLYGON((37.2419964 55.69297, 37.2419964   ))"), null);
    }
}