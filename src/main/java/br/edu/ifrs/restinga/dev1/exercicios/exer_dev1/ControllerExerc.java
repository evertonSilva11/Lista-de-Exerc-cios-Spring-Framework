package br.edu.ifrs.restinga.dev1.exercicios.exer_dev1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Calendar;

@Controller
public class ControllerExerc {

    @RequestMapping("/imc/{peso}/{altura}")
    @ResponseBody
    public String imc(@PathVariable String peso, @PathVariable String altura) {
        String cond = "Obesidade Grau III (mórbida)";
        double p = Double.parseDouble(peso);
        double a = Double.parseDouble(altura);

        double imc = p / (a * a);

        if (imc < 18.5) {
            cond = "Magreza";
        } else if (imc < 24.9) {
            cond = "Saudável";
        } else if (imc < 29.9) {
            cond = "Sobrepeso";
        } else if (imc < 34.9) {
            cond = "Obesidade Grau I";
        } else if (imc < 39.9) {
            cond = "Obesidade Grau II (severa)";
        }

        return "IMC : " + imc + "<br>Condição : " + cond;
    }

    @RequestMapping("/diaSemana/{ano}/{mes}/{dia}")
    @ResponseBody
    public String diaSemana(@PathVariable String ano, @PathVariable String mes, @PathVariable String dia) {
        Calendar cal = Calendar.getInstance();
        int a = Integer.parseInt(ano);
        int m = Integer.parseInt(mes) - 1;
        int d = Integer.parseInt(dia);

        cal.set(a, m, d);

        int diaSem = cal.get(Calendar.DAY_OF_WEEK);

        return switch (diaSem) {
            case Calendar.SUNDAY -> "Domingo";
            case Calendar.MONDAY -> "Segunda-feira";
            case Calendar.TUESDAY -> "Terça-feira";
            case Calendar.WEDNESDAY -> "Quarta-feira";
            case Calendar.THURSDAY -> "Quinta-feira";
            case Calendar.FRIDAY -> "Sexta-feira";
            case Calendar.SATURDAY -> "Sabádo";
            default -> "";
        };
    }

    @RequestMapping("/calculadora/{operacao}")
    @ResponseBody
    public String calculadora(@PathVariable String operacao, @RequestParam("n1") int n1, @RequestParam("n2") int n2) {
        return switch (operacao) {
            case "adicao" -> (n1 + n2) + "";
            case "subtracao" -> (n1 - n2) + "";
            case "multiplicacao" -> (n1 * n2) + "";
            case "divisao" -> (n1 / n2) + "";
            default -> "";
        };
    }

}
