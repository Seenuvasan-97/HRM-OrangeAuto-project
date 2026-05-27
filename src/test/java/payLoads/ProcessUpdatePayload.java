package payLoads;

public class ProcessUpdatePayload {
    public static String getPayload() {

        return """
        {
            "orderID":"801do******OzAAM",
            "orderNumber":"801d******zAAM",
            "requestType":"ProcessUpdate",
            "orderType":"Standard"
        }
        """;
    }
}
