# mob-25-aplicacoes-android-aula4-exercicio3

# Utilizando o SQLite
VersionCode: 1.0

VersionName: "1"

# Introdução
Vamos utilizar o [SQLite](https://www.sqlite.org/index.html) para recuperar as informações entre as telas
# Conexão com banco

## DataBaseManager
Para esse exemplo foi criada uma classe **DataBaseManager** com os seguinte métodos:
- onCreate: Cria um elemento no banco de dados;
- onUpgrade: Atualiza um elemento no banco de dados;
- onInsert: Insere um elemento no bando de dados;
- onList: Listas todos os elementos do banco dados;
- onRemove: Remove um elemento do banco de dados;
## MainActivity
```
val db = DataBaseManager(this, "saudacoes")

btnSalvar.setOnClickListener {
    db.onRemove()
    db.onInsert(1, txtNome.text.toString().trim(), listaTratamento.selectedItem.toString())
    Toast.makeText(this, "Salvo com Sucesso", Toast.LENGTH_SHORT).show()
}
```
Guardando as informações no banco de dados

## SaudacaoActivity
```
val db = DataBaseManager(this, "saudacoes")
val cursor = db.onList()
```
Recuperando todos os elementos inseridos na primeira tela

| Tela 1     | Tela 2     |  
| ------------- | ------------- |
|![Aplicativo 1](img_readme/v1.png)|![Aplicativo 2](img_readme/v1.1.png)|


# Authors

Danilo Santos
[@danilopsnts](https://www.linkedin.com/in/danilopsnts/)