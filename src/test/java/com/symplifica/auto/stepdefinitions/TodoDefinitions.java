package com.symplifica.auto.stepdefinitions;

import com.symplifica.auto.pages.TodoPage;
import com.symplifica.auto.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TodoDefinitions {

    private TodoPage todoPage = new TodoPage();

    @Given("el usuario abre la aplicación Task Manager")
    public void el_usuario_abre_la_aplicación_Task_Manager() {
        String url = ConfigReader.getBaseUrl();
        todoPage.navigateToApp(url);
    }

    @When("añade a una nueva tarea el siguiente título {string}")
    public void añade_a_una_nueva_tarea_el_siguiente_título(String titulo) {
        todoPage.fillInput("TITLE", titulo);
    }

    @And("añade a una nueva tarea la siguiente descripción {string}")
    public void añade_a_una_nueva_tarea_la_siguiente_descripción(String desc) {
        todoPage.fillInput("DESCRIPTION", desc);
    }

    @And("confirma el checkbox Completed Task")
    public void confirma_el_checkbox_Completed_Task() {
        todoPage.clicCompleteCheckbox();
    }

    @Then("hace clic en el botón Add Task")
    public void hace_clic_en_el_botón_Add_Task() {
        todoPage.clicAddTaskBtn();
    }

    @Then("elimina la tarea con el valor {string}")
    public void elimina_la_tarea_con_el_valor(String value) {
        todoPage.clicDeleteButton(value);
    }

    @And("verifica dentro de la lista de tareas, existe el valor {string}")
    public void verifica_dentro_de_la_lista_de_tareas_existe_el_valor(String value) {
        todoPage.verifyTaskCreated(value);
    }

   }