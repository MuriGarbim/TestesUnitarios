import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

public class EmailTest {

    @RunWith(PowerMockRunner.class)
    @PrepareForTest(Email.class)
    public class IdadeMock {

    }

    private int idadeMenor;

    @Before
    public void prepareTests1() {
        idadeMenor = 1;
    }

    @Test
    public void testeValidaMenorIdade() throws Exception {
        //Teste 1 - Valida se o usuário é menor de idade e não prossegue com a criação de email
        //arrange
        Email email = new Email();
        final String METHOD = "getIdade";

        Email spy = PowerMockito.spy(email);
        PowerMockito.when(spy, METHOD).thenReturn((int) 17);

        int actual;
        int expect = 17;

        //act
        actual = spy.validaIdade(idadeMenor);

        //assert
        Assert.assertEquals(expect, actual, 17);
        PowerMockito.verifyPrivate(spy, Mockito
                .times(1))
                .invoke("getIdade");
    }

    @Test
    public void testeAumentaIdade() throws Exception {
        //Teste 2 - Aumenta a idade do usuário caso ele preencha uma idade menor que 18 anos
        //arrange
        Email email = new Email();
        final String METHOD = "getIdade";

        Email spy = PowerMockito.spy(email);
        PowerMockito.when(spy, METHOD).thenReturn((int) 5);

        int actual;
        int expect = 18;

        //act
        actual = spy.aumentaIdade();

        //assert
        Assert.assertTrue(expect  <= actual);
        PowerMockito.verifyPrivate(spy, Mockito
                .times(3))
                .invoke("getIdade");
    }


    @Test
    public void testeValidaEmailMockcomArroba() {
        //Teste 3 - Valida o uso de @ para o campo email
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmail("muriel.garbim@gmail.com");

        //assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testeValidaEmailMocksemArroba() {
        //Teste 4 - Valida o uso de @ para o campo email

        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = false;

        //act
        actual = email.validaEmail("muriel.garbimgmail.com");

        //assert
        Assert.assertEquals(expect, actual);
    }

    @Test
    public void testeValidaSenha(){
        //Teste 5 - Valida que senha tenha no mínimo 8 caracteres
        //arrange
        Email email = new Email();
        final String METHOD = "getSenha";

        int actual;
        int expect = 7;

        //act
        actual = email.validaSenha("desviosk");

        //assert
        Assert.assertTrue(expect < actual);
    }

    @Test
    public void testeValidaSenhaMaisculoCerto(){
        //Teste 6 - Valida que senha tenha pelo menos uma letra Maiuscula
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaSenhaCaracterMaiusculo("Desvios");

        //assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testeValidaSenhaMinusculoIncorreto(){
        //Teste 7 - Valida que não prossiga caso a senha não possua ao menos uma letra maiúscula
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = false;

        //act
        actual = email.validaSenhaCaracterMaiusculo("desvios");

        //assert
        Assert.assertTrue(!actual);
    }

    @Test
    public void testeValidaEmailCorreto(){
        //Teste 8 - Valida que email possua @ no laço de email completo
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmailCompleto(19, "muriel.garbim@gmail.com","Muriel123");

        //assert
        Assert.assertTrue(actual);
    }

    @Test
    public void testeValidaEmailIdadeIncorreta(){
        //Teste 9 - Valida que a criação do email não prossiga se a idade for menor que 18 anos
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmailCompleto(10, "muriel.garbim@gmail.com","Muriel123");

        //assert
        Assert.assertTrue(!actual);
    }

    @Test
    public void testeValidaEmailSemArroba(){
        //Teste 10 - Valida que seja obrigatório o uso do @ no campo email
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmailCompleto(20, "muriel.garbimgmail.com","Muriel123");

        //assert
        Assert.assertTrue(!actual);
    }

    @Test
    public void testeValidaEmailSenhaTamanhoInválido(){
        //Teste 11 - Valida que a criação do email não prossiga se a senha não tiver no mínimo 8 caracteres
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmailCompleto(20, "muriel.garbim@gmail.com","Muriel");

        //assert
        Assert.assertTrue(!actual);
    }

    @Test
    public void testeValidaEmailSenhaMaiusculoInválido(){
        //Teste 12 - Valida que a criação de email não prossiga se a senha não possuir ao menos um caracter Maiusculo
        //arrange
        Email email = new Email();

        boolean actual;
        boolean expect = true;

        //act
        actual = email.validaEmailCompleto(20, "muriel.garbim@gmail.com","muriel123");

        //assert
        Assert.assertTrue(!actual);
    }


}