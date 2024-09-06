package cadusuario;

import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class GestorUsuarios {

    // Map para armazenar usuários com chave como email (único)
    private Map<String, Usuario> usuarios;

    // Construtor
    public GestorUsuarios() {
        usuarios = new HashMap<>();
    }

    /**
     * Adiciona um novo usuário ao sistema.
     * @param usuario O usuário a ser adicionado.
     * @throws IllegalArgumentException Se o email do usuário já existir.
     */
    public void adicionarUsuario(Usuario usuario) {
        if (usuarios.containsKey(usuario.getEmail())) {
            throw new IllegalArgumentException("Usuário com este email já existe.");
        }
        usuarios.put(usuario.getEmail(), usuario);
    }

    /**
     * Busca um usuário pelo email.
     * @param email O email do usuário a ser buscado.
     * @return O usuário correspondente ao email, ou null se não encontrado.
     */
    public Usuario buscarUsuarioPorEmail(String email) {
        return usuarios.get(email);
    }

    /**
     * Lista todos os usuários.
     * @return Uma coleção de todos os usuários.
     */
    public Collection<Usuario> listarUsuarios() {
        return usuarios.values();
    }

	public void removerUsuario(String email) {
		// TODO Auto-generated method stub
		
	}

	public void atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}
}
