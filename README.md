# mob-25-aplicacoes-android-aula4-exercicio1

# SharedPreferences
VersionCode: 1.0

VersionName: "1"

# Introdução
Usando a API SharedPreferences, para salvar informações entre as telas

Neste exemplo, vamos utilizar a palavra **saudacao** como chave para armazenar e depois recuperar o nome digitado e o tratamento escolhido.

Esse comportamento será salvo em um arquivo e depois vamos recuperar essas informações na segunda tela, conforme ilustrações.

## SharedPreferences
### Adicionado 
```
val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
val editor = saudacaoPersistencia.edit()
editor.putString("nome", txtNome.text.toString())
editor.putString("tratamento", listaTratamento.selectedItem.toString())
editor.apply()
```
Os sub-elementos sendo adicionado no arquivo criado pelo SharedPreferences.

### Recuperando
```
val saudacaoPersistencia = this.getSharedPreferences("saudacao", Context.MODE_PRIVATE)
val nome = saudacaoPersistencia.getString("nome", "")
val tratamento = saudacaoPersistencia.getString("tratamento", "")
```


| Tela 1 | Tela 2     |
| ------------- | ------------- |
|![Aplicativo 1](img_readme/v1.png)|![Aplicativo 1](img_readme/v1.1.png)|




# Authors

Danilo Santos
[@danilopsnts](https://www.linkedin.com/in/danilopsnts/)