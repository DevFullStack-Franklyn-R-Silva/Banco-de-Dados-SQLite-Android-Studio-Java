# Banco-de-Dados-SQLite-Android-Studio-Java

 * Introdução ao Banco de dados
 * Banco de Dados - SQLite
 * Aplicando filtros - parte 1
 * Aplicando filtros - parte 2
 * Atualizando e removendo registros - parte 1
 * Atualizando e removendo registros - parte 2
 
## Criar banco de dados
 ```java
SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);
 ```
 ## Criar tabela
 ```java
bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas(id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");
 ```  
 ## Deletar tabela
 ```java
bancoDados.execSQL("DROP TABLE pessoas");
 ```
 ## Inserir dados
 ```java
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Franklyn', 24)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Carlos', 30)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Maria', 35)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Paulo', 35)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Ana', 50)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Pedro', 65)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Alex', 50)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Luiz', 51)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Roberto', 18)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mariana', 18)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Mario', 18)");
bancoDados.execSQL("INSERT INTO pessoas(nome, idade) VALUES ('Silva', 18)");         
 ```
 ## Update do dados
 ```java
bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Mariana Santos'  WHERE id = 3");
```
## Deleta um dado da tabela
```java
bancoDados.execSQL("DELETE FROM pessoas WHERE id = 10");
```
## Deletar todos dados da tabela
```java
bancoDados.execSQL("DELETE FROM pessoas ");
```            
## Recuperar dados
```java
String consulta =
        "SELECT nome, idade FROM pessoas " +
        "WHERE nome = 'Franklyn' AND idade = 24";
        
String consulta =
        "SELECT nome, idade FROM pessoas " +
        "WHERE idade >= 30 OR idade = 24";
        
String consulta =
        "SELECT nome, idade FROM pessoas " +
        "WHERE idade IN(24,30)";
        
String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE nome IN('Carlos','Franklyn')";
                
String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE idade BETWEEN 24 AND 35";
                
String filtro = "mar";
String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE nome LIKE '%" + filtro + "%'";
                
String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE 1=1 ORDER BY nome ASC";
                
String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE 1=1 ORDER BY idade DESC";
                
 String consulta =
        "SELECT nome, idade FROM pessoas " +
                "WHERE 1=1 ORDER BY idade DESC LIMIT 3";               
```           
## Indices da tabela
```java
Cursor cursor = bancoDados.rawQuery(consulta, null);

//Indices da tabela
int indiceId = cursor.getColumnIndex("id");
int indiceNome = cursor.getColumnIndex("nome");
int indiceIdade = cursor.getColumnIndex("idade");

cursor.moveToFirst();
while (cursor != null) {

    String id = cursor.getString(indiceId);
    String nome = cursor.getString(indiceNome);
    String idade = cursor.getString(indiceIdade);

    Log.i("Resultado - id " + id + " | nome ", nome + " | idade: " + idade);

    cursor.moveToNext();
}
```
