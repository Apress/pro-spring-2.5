package com.apress.prospring2.ch11.domain;

/**
 * @author janm
 */
public class LobTest extends AbstractIdentityVersionedObject<Long> {
    private String textContent;
    private byte[] binaryContent;
    private String mimeType;

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public byte[] getBinaryContent() {
        return binaryContent;
    }

    public void setBinaryContent(byte[] binaryContent) {
        this.binaryContent = binaryContent;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LobTest { id=").append(this.id).append(", ");
        sb.append("textContent=").append(this.textContent).append(", ");
        sb.append("binaryContent=");
        for (int i = 0; i < this.binaryContent.length && i < 50; i++) {
            sb.append(String.format("%x", (int)this.binaryContent[i]));
        }
        sb.append("}");

        return sb.toString();
    }
}
