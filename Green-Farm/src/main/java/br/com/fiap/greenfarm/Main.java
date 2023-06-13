package br.com.fiap.greenfarm;

import br.com.fiap.greenfarm.model.Atividades;
import br.com.fiap.greenfarm.model.Dicas;
import br.com.fiap.greenfarm.model.Suporte;
import br.com.fiap.greenfarm.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.*;
import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("oracle");
        EntityManager manager = factory.createEntityManager();


        save(manager);

        findAll(manager);

        findById(manager);


    }

    private static void findById(EntityManager manager) {
        Long id = Long.valueOf(JOptionPane.showInputDialog("Digite o ID do usuário a ser localizado: "));

        Usuario usuario = manager.find(Usuario.class, id);
        System.out.println(usuario);
    }

    private static void findAll(EntityManager manager) {
        String jpql = "From Usuario";

        List<Usuario> resultList = manager.createQuery(jpql).getResultList();

        resultList.stream().forEach(System.out::println);
    }

    private static void save(EntityManager manager) {
        Usuario usuario = new Usuario();

        String nomeUsuario = JOptionPane.showInputDialog("Digite o nome do usuário: ");
        String emailUsuario = JOptionPane.showInputDialog("Digite o email do usuário: ");
        String senhaUsuario = JOptionPane.showInputDialog("Digite uma senha para o usuário: ");

        usuario.setNome_usuario(nomeUsuario).setEmail_usuario(emailUsuario).setSenha_usuario(senhaUsuario);

        System.out.println("Usuário Cadastrado com sucesso.");

        Atividades atividades = new Atividades();

        String tipoAtividade = JOptionPane.showInputDialog("Digite o tipo atividade que deseja cadastrar: ");
        String descricaoAtividade = JOptionPane.showInputDialog("Digite uma descrição para sua atividade: ");

        atividades.setTipo_atividade(tipoAtividade).setDescricao_atividade(descricaoAtividade).setData_atividade(LocalDate.now());

        System.out.println("Atividade Cadastrada com sucesso.");

        Dicas dicas = new Dicas();

        String tituloDica = JOptionPane.showInputDialog("Tipo da dica de agricultura a ser cadastrada: ");
        String descricaoDica = JOptionPane.showInputDialog("Descrição da dica de agricultura a ser cadastrada: ");
        String imgDica = JOptionPane.showInputDialog("URL da imagem da dica de agricultura a ser cadastrada: ");
        String tipoDica = JOptionPane.showInputDialog("Tipo da dica de agricultura a ser cadastrada: ");

        dicas.setTitulo_dica(tituloDica).setDesc_dica(descricaoDica).setImg_dica(imgDica).setTipo_dica(tipoDica);

        System.out.println("Dica Cadastrada com sucesso.");

        Suporte suporte = new Suporte();

        String emailSuporte = JOptionPane.showInputDialog("Digite um email onde gostaria de ser contado para o suporte: ");
        String mensagemSuporte = JOptionPane.showInputDialog("Descreva seu problema/feedback/sugestão: ");

        suporte.setEmail_suporte(emailSuporte).setMensagem_suporte(mensagemSuporte);

        System.out.println("Suporte enviado com sucesso, contataremos em breve :).");

        manager.getTransaction().begin();
        manager.persist(usuario);
        manager.persist(atividades);
        manager.persist(dicas);
        manager.persist(suporte);
        manager.getTransaction().commit();
    }


}