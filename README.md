<div align="center">

# 📱 ContratAí

### Conectando profissionais a quem precisa de seus serviços.


[![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://www.java.com/)
[![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/)
[![SQLite](https://img.shields.io/badge/SQLite-003B57?style=for-the-badge&logo=sqlite&logoColor=white)](https://www.sqlite.org/)
[![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://gradle.org/)

![Plataforma](https://img.shields.io/badge/Plataforma-Android-2ea44f?style=flat-square)
![Versão](https://img.shields.io/badge/Vers%C3%A3o-1.0-blue?style=flat-square)
![Min SDK](https://img.shields.io/badge/Min%20SDK-21-informational?style=flat-square)
![Status](https://img.shields.io/badge/Status-Projeto%20acad%C3%AAmico-orange?style=flat-square)

[**Visão geral**](#-sobre-o-projeto) · [**Funcionalidades**](#-funcionalidades) · [**Tecnologias**](#-tecnologias) · [**Instalação**](#-como-executar) · [**Como usar**](#-como-utilizar)

</div>

---

## 💡 Sobre o projeto

O **ContratAí** é um aplicativo para **Android** desenvolvido com o objetivo de aproximar **prestadores de serviços** e **pessoas interessadas em contratá-los**.

Por meio de uma interface organizada por categorias, os usuários podem encontrar serviços disponíveis, consultar descrições, valores e informações de contato. Prestadores podem cadastrar suas ofertas para divulgação no aplicativo.

O projeto foi criado para colocar em prática conhecimentos de **desenvolvimento mobile com Java**, construção de interfaces Android e persistência local de dados com **SQLite**.

> [!NOTE]
> Esta é uma aplicação **acadêmica e demonstrativa**. O botão de contratação exibe uma confirmação, mas não realiza pagamento ou registra uma contratação efetiva.

## ✨ Funcionalidades

| Recurso | Descrição |
| :--- | :--- |
| 👤 **Cadastro de usuários** | Criação de contas para contratantes e prestadores de serviços. |
| 🔐 **Login** | Acesso com nome de usuário e senha. |
| 🛠️ **Cadastro de serviços** | Registro de categoria, descrição, preço e contato. |
| 🔎 **Exploração por categoria** | Consulta de serviços conforme a categoria escolhida. |
| 📋 **Detalhes dos serviços** | Visualização das informações de cada oferta. |
| ✅ **Contratação demonstrativa** | Exibição de uma mensagem de confirmação ao selecionar a opção de contratar. |

### 🗂️ Categorias disponíveis

`🧹 Serviços gerais` · `🍽️ Alimentação` · `💻 Tecnologia` · `🚚 Frete` · `📚 Educação`

## 🧰 Tecnologias

| Tecnologia | Finalidade |
| :--- | :--- |
| **Java** | Lógica de negócio e funcionalidades do aplicativo. |
| **Android SDK** | Componentes e APIs nativas Android. |
| **XML** | Definição das telas e layouts. |
| **SQLite** | Persistência local dos dados. |
| **Android Studio** | Desenvolvimento e execução. |
| **Gradle** | Compilação e gerenciamento de dependências. |

### ⚙️ Configuração técnica

| Item | Versão / configuração |
| :--- | :--- |
| Linguagem | Java 8 (compatibilidade do projeto) |
| Gradle Wrapper | 7.4 |
| Android Gradle Plugin | 7.3.0 |
| `minSdk` | 21 — Android 5.0 |
| `targetSdk` | 32 |
| `compileSdk` | 32 |
| Versão do app | 1.0 |
| Banco de dados | SQLite local |

## 🚀 Como executar

### Pré-requisitos

- [Android Studio](https://developer.android.com/studio) instalado.
- Android SDK configurado, incluindo a plataforma **API 32**.
- JDK compatível com o **Android Gradle Plugin 7.3.0** (por exemplo, JDK 11).
- Emulador ou dispositivo Android com versão **5.0 ou superior**.
- Internet na primeira sincronização das dependências.

### 1. Clonar o repositório

```bash
git clone https://github.com/Henric-ops/AppContratAi.git
cd AppContratAi
```

Também é possível usar **Code → Download ZIP** na página do GitHub e extrair o projeto.

### 2. Abrir no Android Studio

No Android Studio, selecione **Open** e escolha a pasta raiz do projeto (a que contém `settings.gradle` e os arquivos do Gradle).

### 3. Sincronizar o Gradle

Aguarde a sincronização automática ou utilize **Sync Project with Gradle Files**. Caso solicitado, instale os componentes ausentes do Android SDK.

### 4. Escolher o dispositivo

Inicie um emulador pelo **Device Manager** ou conecte um celular Android com a **Depuração USB** habilitada.

### 5. Executar

Clique em **Run ▶** e selecione o dispositivo desejado. O Android Studio compilará e instalará o aplicativo.

**Banco de dados:** o SQLite é utilizado localmente pelo app; não é necessário configurar um servidor de banco de dados externo.

## 📲 Como utilizar

1. **Criar uma conta:** escolha o perfil de contratante ou prestador e preencha os dados solicitados.
2. **Fazer login:** entre com suas credenciais cadastradas.
3. **Divulgar um serviço:** no fluxo do prestador, informe a categoria, a descrição, o preço e o contato.
4. **Explorar serviços:** acesse as categorias na tela principal e consulte as ofertas disponíveis.
5. **Ver detalhes:** selecione um serviço para conferir as informações cadastradas.
6. **Simular a contratação:** utilize o botão de contratação para visualizar a mensagem demonstrativa.

## 🗃️ Organização do projeto

```text
AppContratAi/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/appcontratai/
│   │       │   ├── MainActivity.java
│   │       │   ├── TelaPrincipal.java
│   │       │   ├── TelaCadastro.java
│   │       │   ├── TelaCadPrestador.java
│   │       │   ├── TelaListaServicos.java
│   │       │   ├── TelaDescricao.java
│   │       │   ├── Usuario.java
│   │       │   ├── UsuarioController.java
│   │       │   ├── Servico.java
│   │       │   ├── ServicoController.java
│   │       │   └── conectadb.java
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   └── build.gradle
├── gradle/
├── build.gradle
└── settings.gradle
```

## ⚠️ Limitações atuais

- **Contratação simulada:** o aplicativo não registra solicitações de contratação nem processa pagamentos.
- **Dados locais:** os cadastros ficam no SQLite do dispositivo, sem sincronização entre aparelhos.
- **Autenticação básica:** a implementação de login requer melhorias de segurança antes de ser utilizada em produção.

## 🔭 Possíveis melhorias

- [ ] Implementar solicitações reais de contratação.
- [ ] Criar histórico e acompanhamento das contratações.
- [ ] Adicionar armazenamento remoto e sincronização de dados.
- [ ] Melhorar a segurança da autenticação e o armazenamento de senhas.
- [ ] Incluir pesquisa de serviços e avaliações de prestadores.
- [ ] Aprimorar a interface e a experiência de uso.

## 🎯 Objetivo acadêmico

O ContratAí foi desenvolvido para consolidar conhecimentos de **programação orientada a objetos, desenvolvimento Android, layouts XML, persistência de dados e navegação entre telas**, aplicados a um cenário de divulgação e consulta de serviços.

## 👨‍💻 Autor

**Henric Baccin**

[![GitHub](https://img.shields.io/badge/GitHub-Henric--ops-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/Henric-ops)
[![Portfólio](https://img.shields.io/badge/Portf%C3%B3lio-Visitar-22C55E?style=for-the-badge&logo=googlechrome&logoColor=white)](https://henric-ops.github.io/henric-portifolio/)

---

<div align="center">


⭐ **Se este projeto foi útil para você, considere deixar uma estrela no repositório!**

</div>
