# Hibernate tags

### @Entity

Declara la clase como una entidad.

```java
@Entity
public class Alumno extends Usuario {
    
}
```

### @Table

Se establece en el nivel de clase. Le permite definir la tabla para su asignación de la entidad. Si no se define @Table, se utilizan los valores predeterminados: el nombre de clase no calificado de la entidad.

```java
@Entity
@Table(name = "Alumno")
public class Alumno extends Usuario {
    
}
```

### @Id

Declara la propiedad identificadora de esta entidad.

```java
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    private Integer id;

  
}
```

### @Column

Define la columna utilizada para un mapeo de propiedades.

```java
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "Id", nullable = false)
    private Integer id;
    
}
```

### @GeneratedValue

Se puede definir la estrategia de generación de identificadores.

```java
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
```

### @DiscriminatorValue

Define el valor usado para diferenciar una clase en la jerarquía.

```java
@Entity
@DiscriminatorValue("1")
public class Profesor extends Usuario {

}
```
```java
@Entity
@DiscriminatorValue("2")
public class Alumno extends Usuario {

}

```

### @JoinColumn

La columna de unión se declara con la anotación @JoinColumn que se parece a la anotación @Column.

```java
@Entity
@DiscriminatorValue("1")
public class Profesor extends Usuario {

    @JoinColumn(name = "Id", nullable = false)
    private Grupo grupo;
    


}
```
```java
@Entity
@Table(name = "Grupo")
public class Grupo {

    @Id
    @Column(name = "Id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;


}

```

### @OneToOne

Se puede usar dentro de una clase para especificar una relación de la clase a una clase de entidad.

```java
@Entity
@Table(name = "Lector")
public class Lector {

    @OneToOne
    @JoinColumn(name = "Id", nullable = false)
    private Aula aula;

}
```

### @OneToMany

Define una asociación de muchos valores con multiplicidad de uno a muchos.

```java
@Entity
@Table(name = "Lector")
public class Lector {

    @OneToMany(mappedBy = "lector")
    private Set<Fichaje> signings;

}
```
```java
@Entity
@Table(name = Signing)
public class Fichaje {

    @ManyToOne(fetch = FetchType.LAZY)
    private Lector lector;


}
```

### @ManyToOne

Define una asociación de un solo valor para otra clase de entidad que tiene una multiplicidad de muchos a uno.

```java
@Entity
@Table(name = Signing)
public class Fichaje {

    @ManyToOne(fetch = FetchType.LAZY)
    private Lector lector;


}
```
```java
@Entity
@Table(name = "Lector")
public class Lector {

    @OneToMany(mappedBy = "lector")
    private Set<Fichaje> signings;

}
```
