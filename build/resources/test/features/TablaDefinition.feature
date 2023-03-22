Feature: completar tabla
  yo como administrador de la Web demoQA
  quiero dirigirme a la seccion de elementos web
  para poder ingresar la informacion de personas contratadas

  Scenario Outline: Registro exitoso
    Given el administrador esta en la pagina principal
    When navega hasta la opcion de elementos en la opcion Web tables
    And completa con nombre <firstName>, apellido <lastName>, edad <age>, correo electronico <email>, salario <salary>, departamento <department>
    Then debe observar una tabla con la informacion ingresada

    Examples:
      | firstName | lastName   | age   | email              | salary    | department |
      | "Diego"   | "Buitrago" | "12"  | "diegom@gmail.com" | "2000000" | "QA"       |
      | "yeison"  | "osorio"   | "10"  | "yeison@gmail.com" | "1400000" | "QA"       |
      | "Mariana" | "Monsalve" | "155" | "mar@gmail.com"    | "5000000" | "QA"       |
