/**
 * Representa um documento a ser impresso, contendo ID, tipo e número de páginas.
 */
public class Documento {
    private final int id;
    private final String tipo;
    private final int paginas;

    public Documento(int id, String tipo, int paginas) {
        this.id = id;
        this.tipo = tipo;
        this.paginas = paginas;
    }

    public int getId() {
        return id;
    }

    public int getPaginas() {
        return paginas;
    }

    /**
     * Retorna uma representação formatada do documento.
     */
    @Override
    public String toString() {
        return String.format("[ID: %04d | %-5s | %03d pgs]", id, tipo, paginas);
    }
}