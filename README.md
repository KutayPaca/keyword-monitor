# KeywordMonitorProject

## English Version

This project is a Java application that scans a text file for specific **keywords** and logs them according to their severity levels.  
The logger writes to both the terminal and a log file. All detected keywords are also reported collectively through an exception.

### Features

- Reads the file **line by line**
- **Case-sensitive** keyword detection
- Keyword → Log Level mapping using a Map
- Logs according to **SEVERE / WARNING / INFO** levels
- Logger writes to both terminal and file
- All detected keywords are reported via an exception

### Project Structure
````
KeywordMonitorProject/
│
├─ src/
│ └─ main/
│ ├─ java/
│ │ └─ keywordmonitor/
│ │ ├─ Main.java
│ │ ├─ KeywordMonitorService.java
│ │ └─ NotValidException.java
│ │
│ └─ resources/
│ └─ test.txt
````

### Keyword → Log Levels

| Keyword     | Level    | Description                     |
|------------|---------|--------------------------------|
| ERROR      | SEVERE  | Critical error                 |
| FAIL       | SEVERE  | Failed operation               |
| CRITICAL   | SEVERE  | Critical situation             |
| WARNING    | WARNING | Warning                        |
| SUSPICIOUS | WARNING | Suspicious activity            |
| DEPRECATED | WARNING | Deprecated usage               |
| INFO       | INFO    | Informational message          |
| NOTE       | INFO    | Note                           |
| LOG        | INFO    | General log                    |

### How to Run

1. Open the project in IntelliJ or another IDE
2. Make sure `src/main/resources/test.txt` exists with sample content
3. Run `Main.java`
4. Check logs in terminal and in `keywordmonitor.log` file

---

## Türkçe Versiyon

Bu proje, bir metin dosyasındaki belirli **keyword’leri (anahtar kelimeleri)** tarayan ve seviyelerine göre loglayan bir Java uygulamasıdır.  
Logger hem terminale hem de bir log dosyasına yazmaktadır. Ayrıca, bulunan tüm keyword’ler topluca bir exception ile raporlanır.

### Özellikler

- Dosya satır satır okunur
- **Büyük/küçük harf duyarlı** keyword kontrolü
- Keyword → Log Level Map ile seviyelendirme
- SEVERE / WARNING / INFO seviyelerine göre loglama
- Logger hem terminal hem dosyaya yazıyor
- Tüm bulunan keyword’ler topluca exception ile raporlanır

### Proje Yapısı
````
KeywordMonitorProject/
│
├─ src/
│ └─ main/
│ ├─ java/
│ │ └─ keywordmonitor/
│ │ ├─ Main.java
│ │ ├─ KeywordMonitorService.java
│ │ └─ NotValidException.java
│ │
│ └─ resources/
│ └─ test.txt
````

### Keyword → Log Seviyeleri

| Keyword     | Seviyesi | Açıklama                            |
|------------|---------|------------------------------------|
| ERROR      | SEVERE  | Kritik hata                        |
| FAIL       | SEVERE  | Operasyon başarısız                 |
| CRITICAL   | SEVERE  | Kritik durum                        |
| WARNING    | WARNING | Uyarı                               |
| SUSPICIOUS | WARNING | Şüpheli durum                        |
| DEPRECATED | WARNING | Kullanımdan kalkmış                 |
| INFO       | INFO    | Bilgi                               |
| NOTE       | INFO    | Not                                  |
| LOG        | INFO    | Genel log                            |

### Çalıştırma

1. IntelliJ veya başka bir IDE’de projeyi açın
2. `src/main/resources/test.txt` dosyasının mevcut olduğundan emin olun ve örnek içerik ekleyin
3. `Main.java` dosyasını çalıştırın
4. Terminalde ve `keywordmonitor.log` dosyasında logları görebilirsiniz
