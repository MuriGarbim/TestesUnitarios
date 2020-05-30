public class Email {
        public String Nome = "Muriel Linda";
      //  public String Email = "muriel@linda.com.br";
      //  public String Senha = "domeucoracao";
        public int Idade = 31;
       // public boolean Ativo = true;
       // public char Apresentacao = 'm';


    public static void main(String[] args){
            Email email = new Email();

            System.out.print(email.Nome);
        }


    public int validaIdade (int Idade){
        //Valida se usuário é maior de 18 anos
        if (getIdade() >= 18 ) {
            System.out.println("Prosseguir");
        }
        else {
            System.out.println("Você precisa ter mais de 18 anos para criar seu email");
        }
        return Idade;
    }
    public void setIdade(int idade) {
        Idade = idade;
    }
    public int getIdade() {
        return Idade;
    }

    public int aumentaIdade (){
        //Valida se usuário é maior de 18 anos se não for aumenta a idade para 18
        if (getIdade() >= 18 ) {
            System.out.println("Prosseguir");
        }
        else {
            int complemento = (18 - getIdade());
            setIdade(getIdade() + complemento );
            System.out.println("Você precisoo ganhar " + complemento + " para usar o e-mail");
        }
        return Idade;
    }

    public boolean validaEmail (String novoEmail){
            //Valida se o email é valido contendo @
        if (novoEmail.contains("@") ) {
                System.out.println("Email válido");
            }
            else {
                System.out.println("Email inválido");
            }
        return novoEmail.contains("@");
    }

   // public int tamanhoEmail (String novoEmail){
            //Valida que o email não ultrapasse 40 caracteres e tenha no mínimo 10 caracteres
    //    if (novoEmail.length() <= 40 && novoEmail.length() >= 10) {
   //         System.out.println("Email válido");
     //   }
     //   else {
     //       if (novoEmail.length() > 40){
         //       System.out.println("Email não pode conter mais de 40 caracteres");
        //    }
       //     else{
         //       System.out.println("Email não pode conter menos de 10 caracteres");
     //       }
     //   }
    //    return novoEmail.length();
 //   }

    public int validaSenha(String senha){
        //Valida que a senha tenha no mínimo 8 caracteres
        if (senha.length() >= 8){
            System.out.println("Senha criada com sucesso");
        }
        else {
            if (senha.length() < 8){
                System.out.println("Senha precisa conter no mínimo 8 caracteres");
            }
        }
        return senha.length();
    }

    public boolean validaSenhaCaracterMaiusculo(String senha){
        //Valida que a senha contem no mínimo um caracter maiúsculo
        if (!senha.toLowerCase().equals(senha)){
            System.out.println("Senha criada com sucesso");
        }
        else {
            System.out.println("Sua senha precisa no mínimo de um caracter maiúsculo");
        }
        return (!senha.toLowerCase().equals(senha));
    }

    public boolean validaEmailCompleto (int Idade, String email, String senha){
        //Valida a criação do email se os dados estiverem corretos
        boolean emailValido;
        if (validaIdade(Idade) >= 18 ) {
            System.out.println("Validação de idade correta");
            emailValido = true;
            if (validaEmail(email)){
                System.out.println("Validação de email correta");
                emailValido = true;
                if (validaSenha(senha) >= 8 ){
                    System.out.println("Validação tamanho de senha correta");
                    emailValido = true;
                    if (validaSenhaCaracterMaiusculo(senha)){
                        System.out.println("Validação de senha com caracter maiúsculo correta");
                        emailValido = true;
                    }
                    else{
                        System.out.println("Email não criado um caracter maiúsculo");
                        emailValido = false;
                    }
                }else{
                    System.out.println("Email não criado por senha possuir menos de 8 caracteres");
                    emailValido = false;
                }
            }
            else{
                System.out.println("Validação de idade correta, porém email não possui @");
                emailValido = false;
            }
        }
        else {
            System.out.println("Você precisa ter mais de 18 anos para criar seu email");
            emailValido = false;
        }
        return emailValido;
    }
}
