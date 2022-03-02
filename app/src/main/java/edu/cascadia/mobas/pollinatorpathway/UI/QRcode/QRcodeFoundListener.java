package edu.cascadia.mobas.pollinatorpathway.ui.QRcode;

public interface QRcodeFoundListener {
    void onQRCodeFound(String qrCode);
    void qrCodeNotFound();
}

