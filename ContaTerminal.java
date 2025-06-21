import java.util.InputMismatchException;
import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            int numeroConta = lerNumeroConta(scanner);
            String agencia = lerAgencia(scanner);
            String nomeCliente = lerNomeCliente(scanner);
            double saldo = lerSaldo(scanner);

            exibirMensagemBoasVindas(nomeCliente, agencia, numeroConta, saldo);
        } catch (InputMismatchException e) {
            System.out.println("Entrada inválida. Por favor, reinicie o programa e insira os dados corretamente.");
        } finally {
            scanner.close();
        }
    }

    private static int lerNumeroConta(Scanner scanner) {
        System.out.print("Por favor, digite o número da conta: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Número inválido. Digite novamente: ");
            scanner.next();
        }
        int numeroConta = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        return numeroConta;
    }

    private static String lerAgencia(Scanner scanner) {
        System.out.print("Por favor, digite o número da Agência: ");
        return scanner.nextLine();
    }

    private static String lerNomeCliente(Scanner scanner) {
        System.out.print("Por favor, digite o nome do Cliente: ");
        return scanner.nextLine();
    }

    private static double lerSaldo(Scanner scanner) {
        System.out.print("Por favor, digite o Saldo Inicial: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Valor inválido. Digite novamente: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static void exibirMensagemBoasVindas(String nome, String agencia, int conta, double saldo) {
        String mensagem = String.format(
                "Olá %s, obrigado por criar uma conta em nosso banco. Sua agência é %s, conta %d e seu saldo R$ %.2f já está disponível para saque.",
                nome, agencia, conta, saldo
        );
        System.out.println(mensagem);
    }
}
