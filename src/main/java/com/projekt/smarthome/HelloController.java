package com.projekt.smarthome;

import javafx.animation.*;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import java.net.URL;
import java.sql.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class HelloController implements Initializable {
    @FXML
    private Button BRBlind1,BRBlind2,BRBlind3,BRBlind4,BRBlind5,BRBlind6,BRBlind7,BRBlind8,BRBlind9;
    @FXML
    private Button Blights1,Blights2,Blights3,Blights4,Blights5,Blights6,Blights7,Blights8,Blights9;
    @FXML
    private Button Btemp1,Btemp2,Btemp3,Btemp4,Btemp5,Btemp6,Btemp7;
    @FXML
    private TabPane MainTabPane;
    @FXML
    private Tab RblindTab;
    @FXML
    private Pane one,two,three,four,five,six,seven,eight,nine;
    @FXML
    private Pane one1,two1,three1,four1,five1,six1,seven1,eight1,nine1;
    @FXML
    private Pane one11,two11,three11,four11,five11,six11,seven11;
    @FXML
    private AnchorPane homePane;
    @FXML
    private Tab homeTab;
    @FXML
    private Label label1,label2,label3,label4,label5,label6,label7,label8,label9;
    @FXML
    private Label label11,label21,label31,label41,label51,label61,label71,label81,label91;
    @FXML
    private Label label111,label211,label311,label411,label511,label611,label711;
    @FXML
    private AnchorPane lightsPane;
    @FXML
    private Slider lightsSlider1,lightsSlider2,lightsSlider3,lightsSlider4,lightsSlider5,lightsSlider6,lightsSlider7,lightsSlider8,lightsSlider9;
    @FXML
    private Slider blindsSlider1,blindsSlider2,blindsSlider3,blindsSlider4,blindsSlider5,blindsSlider6,blindsSlider7,blindsSlider8,blindsSlider9;
    @FXML
    private Slider tempslider1,tempslider2,tempslider3,tempslider4,tempslider5,tempslider6,tempslider7;
    @FXML
    private Tab lightsTab;
    @FXML
    private ImageView logo;
    @FXML
    private ImageView opis;
    @FXML
    private AnchorPane rBlindPane;
    @FXML
    private AnchorPane temperaturePane;
    @FXML
    private Tab temperatureTab;
    @FXML
    private Label time;
    TranslateTransition paneOne = new TranslateTransition();
    TranslateTransition paneTwo = new TranslateTransition();
    TranslateTransition paneThree = new TranslateTransition();
    TranslateTransition paneFour = new TranslateTransition();
    TranslateTransition paneFive = new TranslateTransition();
    TranslateTransition paneSix = new TranslateTransition();
    TranslateTransition paneSeven = new TranslateTransition();
    TranslateTransition paneEight = new TranslateTransition();
    TranslateTransition paneNine = new TranslateTransition();
    FadeTransition FadeOne = new FadeTransition();
    FadeTransition FadeTwo = new FadeTransition();
    FadeTransition FadeThree = new FadeTransition();
    FadeTransition FadeFour = new FadeTransition();
    FadeTransition FadeFive = new FadeTransition();
    FadeTransition FadeSix = new FadeTransition();
    FadeTransition FadeSeven = new FadeTransition();
    FadeTransition FadeEight = new FadeTransition();
    FadeTransition FadeNine = new FadeTransition();
    TranslateTransition paneOne1 = new TranslateTransition();
    TranslateTransition paneTwo1 = new TranslateTransition();
    TranslateTransition paneThree1 = new TranslateTransition();
    TranslateTransition paneFour1 = new TranslateTransition();
    TranslateTransition paneFive1 = new TranslateTransition();
    TranslateTransition paneSix1 = new TranslateTransition();
    TranslateTransition paneSeven1 = new TranslateTransition();
    TranslateTransition paneEight1 = new TranslateTransition();
    TranslateTransition paneNine1 = new TranslateTransition();
    FadeTransition FadeOne1 = new FadeTransition();
    FadeTransition FadeTwo1 = new FadeTransition();
    FadeTransition FadeThree1 = new FadeTransition();
    FadeTransition FadeFour1 = new FadeTransition();
    FadeTransition FadeFive1 = new FadeTransition();
    FadeTransition FadeSix1 = new FadeTransition();
    FadeTransition FadeSeven1 = new FadeTransition();
    FadeTransition FadeEight1 = new FadeTransition();
    FadeTransition FadeNine1 = new FadeTransition();
    TranslateTransition paneOne2 = new TranslateTransition();
    TranslateTransition paneTwo2 = new TranslateTransition();
    TranslateTransition paneThree2 = new TranslateTransition();
    TranslateTransition paneFour2 = new TranslateTransition();
    TranslateTransition paneFive2 = new TranslateTransition();
    TranslateTransition paneSix2 = new TranslateTransition();
    TranslateTransition paneSeven2 = new TranslateTransition();
    FadeTransition FadeOne2 = new FadeTransition();
    FadeTransition FadeTwo2 = new FadeTransition();
    FadeTransition FadeThree2 = new FadeTransition();
    FadeTransition FadeFour2 = new FadeTransition();
    FadeTransition FadeFive2 = new FadeTransition();
    FadeTransition FadeSix2 = new FadeTransition();
    FadeTransition FadeSeven2 = new FadeTransition();
    int countLightsTabClicked = 0;
    int countRBlindTabClicked = 0;
    int countTemperatureTabClicked = 0;
    int light1,light2,light3,light4,light5,light6,light7,light8,light9;
    int rblind1,rblind2,rblind3,rblind4,rblind5,rblind6,rblind7,rblind8,rblind9;
    int temperature1,temperature2,temperature3,temperature4,temperature5,temperature6,temperature7;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //połączenie z bazą, potrzebne jako parametr do wywołania metody setSliderValue
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:project.db");
        } catch (SQLException ignored) {
        }

        //wywoływanie metody setSliderValue dla wszystkich kafelków programu
        setSliderValue(connection, "KITCHEN_MAIN", lightsSlider1, "LIGHTS" );
        light1 = (int) lightsSlider1.getValue();
        label1.setText(light1 + "%"); //ustawienie wartości z suwaków do odpowiadającej etykiety - w tym przypadku do label1, poniżej dla wszystkich pozostałych

        setSliderValue(connection, "KITCHEN_CUPBOARDS", lightsSlider2, "LIGHTS" );
        light2 = (int) lightsSlider2.getValue();
        label2.setText(light2 + "%");

        setSliderValue(connection, "SALOON_MAIN", lightsSlider3, "LIGHTS" );
        light3 = (int) lightsSlider3.getValue();
        label3.setText(light3 + "%");

        setSliderValue(connection, "SALOON_LAMP", lightsSlider4, "LIGHTS" );
        light4 = (int) lightsSlider4.getValue();
        label4.setText(light4 + "%");

        setSliderValue(connection, "BEDROOM1", lightsSlider5, "LIGHTS" );
        light5 = (int) lightsSlider5.getValue();
        label5.setText(light5 + "%");

        setSliderValue(connection, "BEDROOM2", lightsSlider6, "LIGHTS" );
        light6 = (int) lightsSlider6.getValue();
        label6.setText(light6 + "%");

        setSliderValue(connection, "GUEST_ROOM", lightsSlider7, "LIGHTS" );
        light7 = (int) lightsSlider7.getValue();
        label7.setText(light7 + "%");

        setSliderValue(connection, "CORRIDOR1", lightsSlider8, "LIGHTS" );
        light8 = (int) lightsSlider8.getValue();
        label8.setText(light8 + "%");

        setSliderValue(connection, "CORRIDOR2", lightsSlider9, "LIGHTS" );
        light9 = (int) lightsSlider9.getValue();
        label9.setText(light9 + "%");

        //wywołanie metody do aktualizacji danych w bazie danych po naciśnięciu przycisku
        databaseValueUpdate(Blights1, label1, "LIGHTS", "KITCHEN_MAIN");
        databaseValueUpdate(Blights2, label2, "LIGHTS", "KITCHEN_CUPBOARDS");
        databaseValueUpdate(Blights3, label3, "LIGHTS", "SALOON_MAIN");
        databaseValueUpdate(Blights4, label4, "LIGHTS", "SALOON_LAMP");
        databaseValueUpdate(Blights5, label5, "LIGHTS", "BEDROOM1");
        databaseValueUpdate(Blights6, label6, "LIGHTS", "BEDROOM2");
        databaseValueUpdate(Blights7, label7, "LIGHTS", "GUEST_ROOM");
        databaseValueUpdate(Blights8, label8, "LIGHTS", "CORRIDOR1");
        databaseValueUpdate(Blights9, label9, "LIGHTS", "CORRIDOR2");


        setSliderValue(connection, "KITCHEN_LEFT", blindsSlider1, "ROLLER_BLINDS" );
        rblind1 = (int) blindsSlider1.getValue();
        label11.setText(rblind1 + "%");

        setSliderValue(connection, "KITCHEN_RIGHT", blindsSlider2, "ROLLER_BLINDS" );
        rblind2 = (int) blindsSlider2.getValue();
        label21.setText(rblind2 + "%");

        setSliderValue(connection, "SALOON_MAIN", blindsSlider3, "ROLLER_BLINDS" );
        rblind3 = (int) blindsSlider3.getValue();
        label31.setText(rblind3 + "%");

        setSliderValue(connection, "SALOON_MINOR", blindsSlider4, "ROLLER_BLINDS" );
        rblind4 = (int) blindsSlider4.getValue();
        label41.setText(rblind4 + "%");

        setSliderValue(connection, "BEDROOM1", blindsSlider5, "ROLLER_BLINDS" );
        rblind5 = (int) blindsSlider5.getValue();
        label51.setText(rblind5 + "%");

        setSliderValue(connection, "BEDROOM2", blindsSlider6, "ROLLER_BLINDS" );
        rblind6 = (int) blindsSlider6.getValue();
        label61.setText(rblind6 + "%");

        setSliderValue(connection, "GUEST_ROOM", blindsSlider7, "ROLLER_BLINDS" );
        rblind7 = (int) blindsSlider7.getValue();
        label71.setText(rblind7 + "%");

        setSliderValue(connection, "CORRIDOR1", blindsSlider8, "ROLLER_BLINDS" );
        rblind8 = (int) blindsSlider8.getValue();
        label81.setText(rblind8 + "%");

        setSliderValue(connection, "CORRIDOR2", blindsSlider9, "ROLLER_BLINDS" );
        rblind9 = (int) blindsSlider9.getValue();
        label91.setText(rblind9 + "%");

        databaseValueUpdate(BRBlind1, label11, "ROLLER_BLINDS", "KITCHEN_LEFT");
        databaseValueUpdate(BRBlind2, label21, "ROLLER_BLINDS", "KITCHEN_RIGHT");
        databaseValueUpdate(BRBlind3, label31, "ROLLER_BLINDS", "SALOON_MAIN");
        databaseValueUpdate(BRBlind4, label41, "ROLLER_BLINDS", "SALOON_MINOR");
        databaseValueUpdate(BRBlind5, label51, "ROLLER_BLINDS", "BEDROOM1");
        databaseValueUpdate(BRBlind6, label61, "ROLLER_BLINDS", "BEDROOM2");
        databaseValueUpdate(BRBlind7, label71, "ROLLER_BLINDS", "GUEST_ROOM");
        databaseValueUpdate(BRBlind8, label81, "ROLLER_BLINDS", "CORRIDOR1");
        databaseValueUpdate(BRBlind9, label91, "ROLLER_BLINDS", "CORRIDOR2");


        setSliderValue(connection, "KITCHEN", tempslider1, "TEMPERATURE" );
        temperature1 = (int) tempslider1.getValue();
        label111.setText(temperature1 + "°C");

        setSliderValue(connection, "SALOON", tempslider2, "TEMPERATURE" );
        temperature2 = (int) tempslider2.getValue();
        label211.setText(temperature2 + "°C");

        setSliderValue(connection, "BEDROOM1", tempslider3, "TEMPERATURE" );
        temperature3 = (int) tempslider3.getValue();
        label311.setText(temperature3 + "°C");

        setSliderValue(connection, "BEDROOM2", tempslider4, "TEMPERATURE" );
        temperature4 = (int) tempslider4.getValue();
        label411.setText(temperature4 + "°C");

        setSliderValue(connection, "GUEST_ROOM", tempslider5, "TEMPERATURE" );
        temperature5 = (int) tempslider5.getValue();
        label511.setText(temperature5 + "°C");

        setSliderValue(connection, "CORRIDOR1", tempslider6, "TEMPERATURE" );
        temperature6 = (int) tempslider6.getValue();
        label611.setText(temperature6 + "°C");

        setSliderValue(connection, "CORRIDOR2", tempslider7, "TEMPERATURE" );
        temperature7 = (int) tempslider7.getValue();
        label711.setText(temperature7 + "°C");

        //wywołanie osobnej metody, tylko do aktualizaji danych w tabeli z temperaturami("TEMPERATURE")
        tempDatabaseValueUpdate(Btemp1, label111, "TEMPERATURE", "KITCHEN");
        tempDatabaseValueUpdate(Btemp2, label211, "TEMPERATURE", "SALOON");
        tempDatabaseValueUpdate(Btemp3, label311, "TEMPERATURE", "BEDROOM1");
        tempDatabaseValueUpdate(Btemp4, label411, "TEMPERATURE", "BEDROOM2");
        tempDatabaseValueUpdate(Btemp5, label511, "TEMPERATURE", "GUEST_ROOM");
        tempDatabaseValueUpdate(Btemp6, label611, "TEMPERATURE", "CORRIDOR1");
        tempDatabaseValueUpdate(Btemp7, label711, "TEMPERATURE", "CORRIDOR2");

        /*główna linia czasowa uruchamiająca odwrócone animacje przy starcie programu(aby przy przełączeniu zakładki elementy programu były w odpowiedniej
        pozycji wyjściowej do uruchomienia właściwej animacji)*/
        Timeline mainTimeLine = new Timeline(
                new KeyFrame(Duration.millis(10), Event -> reverseLightsTransition()),
                new KeyFrame(Duration.millis(15), Event -> reverseRBlindTransition()),
                new KeyFrame(Duration.millis(20), Event -> reverseTemperatureTransition())
        );
        mainTimeLine.setDelay(Duration.millis(15));
        mainTimeLine.play();


        opis.setVisible(false);
        //EventHandler z warunkiem odpowiadającym za widoczność grafiki opisowej
        MainTabPane.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            if(homeTab.isSelected()) opis.setVisible(false);
            else opis.setVisible(true);
        });
        //uruchomienie animacji przy pierwszym przełączeniu zakładki
        lightsTab.setOnSelectionChanged(event -> {
            if(countLightsTabClicked == 0){
                lightsAnimSet();
            }
            countLightsTabClicked++;
        });

        RblindTab.setOnSelectionChanged(event -> {
            if(countRBlindTabClicked == 0){
                RBlindAnimSet();
            }
            countRBlindTabClicked++;
        });

        temperatureTab.setOnSelectionChanged(event -> {
            if(countTemperatureTabClicked == 0){
                TemperatureAnimSet();
            }
            countTemperatureTabClicked++;
        });

        //animacje do zegara i logo
        TranslateTransition translate = new TranslateTransition();
        translate.setNode(logo);
        translate.setDuration(Duration.millis(850));
        translate.setByY(-200);

        TranslateTransition clock = new TranslateTransition();
        clock.setNode(time);
        clock.setDuration(Duration.millis(850));
        clock.setByY(-200);

        FadeTransition fade = new FadeTransition();
        fade.setNode(logo);
        fade.setNode(time);
        fade.setDuration(Duration.millis(1850));
        fade.setFromValue(0);
        fade.setToValue(1.0);

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(200), actionEvent -> translate.play()),
                new KeyFrame(Duration.millis(200), actionEvent -> fade.play()),
                new KeyFrame(Duration.millis(250), actionEvent -> clock.play())
        );
        timeline.play();

        //kod zapisujący aktualną godzinę systemową do etykiety "time"
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                time.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
            }
        };
        timer.start();

        //wywołanie metody nasłuchującej zmiany w pozycji suwaków
        sliderListener();


    }






    @FXML
    void LightsTabSwitched(Event event){

    }
    @FXML
    void RblindTabSwitched(Event event) {
    }

    //zestaw animacji, wywoływany w initialize w odpowiednim momencie
    public void lightsAnimSet() {
        paneOne.setNode(one);
        paneOne.setDuration(Duration.millis(850));
        paneOne.setByY(-168);

        paneTwo.setNode(two);
        paneTwo.setDuration(Duration.millis(850));
        paneTwo.setByY(-168);

        paneThree.setNode(three);
        paneThree.setDuration(Duration.millis(850));
        paneThree.setByY(-168);

        paneFour.setNode(four);
        paneFour.setDuration(Duration.millis(850));
        paneFour.setByY(-168);

        paneFive.setNode(five);
        paneFive.setDuration(Duration.millis(850));
        paneFive.setByY(-168);

        paneSix.setNode(six);
        paneSix.setDuration(Duration.millis(850));
        paneSix.setByY(-168);

        paneSeven.setNode(seven);
        paneSeven.setDuration(Duration.millis(850));
        paneSeven.setByY(-168);

        paneEight.setNode(eight);
        paneEight.setDuration(Duration.millis(850));
        paneEight.setByY(-168);

        paneNine.setNode(nine);
        paneNine.setDuration(Duration.millis(850));
        paneNine.setByY(-168);

        FadeOne.setNode(one);
        FadeOne.setDuration(Duration.millis(1250));
        FadeOne.setFromValue(0);
        FadeOne.setToValue(1.0);

        FadeTwo.setNode(two);
        FadeTwo.setDuration(Duration.millis(1250));
        FadeTwo.setFromValue(0);
        FadeTwo.setToValue(1.0);

        FadeThree.setNode(three);
        FadeThree.setDuration(Duration.millis(1250));
        FadeThree.setFromValue(0);
        FadeThree.setToValue(1.0);

        FadeFour.setNode(four);
        FadeFour.setDuration(Duration.millis(1250));
        FadeFour.setFromValue(0);
        FadeFour.setToValue(1.0);

        FadeFive.setNode(five);
        FadeFive.setDuration(Duration.millis(1250));
        FadeFive.setFromValue(0);
        FadeFive.setToValue(1.0);

        FadeSix.setNode(six);
        FadeSix.setDuration(Duration.millis(1250));
        FadeSix.setFromValue(0);
        FadeSix.setToValue(1.0);

        FadeSeven.setNode(seven);
        FadeSeven.setDuration(Duration.millis(1250));
        FadeSeven.setFromValue(0);
        FadeSeven.setToValue(1.0);

        FadeEight.setNode(eight);
        FadeEight.setDuration(Duration.millis(1250));
        FadeEight.setFromValue(0);
        FadeEight.setToValue(1.0);

        FadeNine.setNode(nine);
        FadeNine.setDuration(Duration.millis(1250));
        FadeNine.setFromValue(0);
        FadeNine.setToValue(1.0);


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), Event -> FadeOne.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeTwo.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeThree.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeFour.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeFive.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeSix.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeSeven.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeEight.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeNine.play()),
                new KeyFrame(Duration.millis(100), Event -> paneOne.play()),
                new KeyFrame(Duration.millis(120), Event -> paneTwo.play()),
                new KeyFrame(Duration.millis(140), Event -> paneThree.play()),
                new KeyFrame(Duration.millis(160), Event -> paneFour.play()),
                new KeyFrame(Duration.millis(180), Event -> paneFive.play()),
                new KeyFrame(Duration.millis(200), Event -> paneSix.play()),
                new KeyFrame(Duration.millis(220), Event -> paneSeven.play()),
                new KeyFrame(Duration.millis(240), Event -> paneEight.play()),
                new KeyFrame(Duration.millis(260), Event -> paneNine.play())
        );
        timeline.play();
    }
       //zestaw animacji, ustawiający elementy programu(zakładka światła) w odpowiedniej pozycji przy uruchomieniu
       public void reverseLightsTransition() {
           paneOne.setNode(one);
           paneOne.setDuration(Duration.millis(1));
           paneOne.setByY(168);

           paneTwo.setNode(two);
           paneTwo.setDuration(Duration.millis(1));
           paneTwo.setByY(168);

           paneThree.setNode(three);
           paneThree.setDuration(Duration.millis(1));
           paneThree.setByY(168);

           paneFour.setNode(four);
           paneFour.setDuration(Duration.millis(1));
           paneFour.setByY(168);

           paneFive.setNode(five);
           paneFive.setDuration(Duration.millis(1));
           paneFive.setByY(168);

           paneSix.setNode(six);
           paneSix.setDuration(Duration.millis(1));
           paneSix.setByY(168);

           paneSeven.setNode(seven);
           paneSeven.setDuration(Duration.millis(1));
           paneSeven.setByY(168);

           paneEight.setNode(eight);
           paneEight.setDuration(Duration.millis(1));
           paneEight.setByY(168);

           paneNine.setNode(nine);
           paneNine.setDuration(Duration.millis(1));
           paneNine.setByY(168);

           Timeline lightsTimeline = new Timeline(
                   new KeyFrame(Duration.millis(1), Event -> paneOne.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneTwo.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneThree.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneFour.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneFive.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneSix.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneSeven.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneEight.play()),
                   new KeyFrame(Duration.millis(1), Event -> paneNine.play())
                   );
           lightsTimeline.play();
        }

    //zestaw animacji, wywoływany w initialize w odpowiednim momencie
    public void RBlindAnimSet() {
        paneOne1.setNode(one1);
        paneOne1.setDuration(Duration.millis(850));
        paneOne1.setByY(-168);

        paneTwo1.setNode(two1);
        paneTwo1.setDuration(Duration.millis(850));
        paneTwo1.setByY(-168);

        paneThree1.setNode(three1);
        paneThree1.setDuration(Duration.millis(850));
        paneThree1.setByY(-168);

        paneFour1.setNode(four1);
        paneFour1.setDuration(Duration.millis(850));
        paneFour1.setByY(-168);

        paneFive1.setNode(five1);
        paneFive1.setDuration(Duration.millis(850));
        paneFive1.setByY(-168);

        paneSix1.setNode(six1);
        paneSix1.setDuration(Duration.millis(850));
        paneSix1.setByY(-168);

        paneSeven1.setNode(seven1);
        paneSeven1.setDuration(Duration.millis(850));
        paneSeven1.setByY(-168);

        paneEight1.setNode(eight1);
        paneEight1.setDuration(Duration.millis(850));
        paneEight1.setByY(-168);

        paneNine1.setNode(nine1);
        paneNine1.setDuration(Duration.millis(850));
        paneNine1.setByY(-168);

        FadeOne1.setNode(one1);
        FadeOne1.setDuration(Duration.millis(1250));
        FadeOne1.setFromValue(0);
        FadeOne1.setToValue(1.0);

        FadeTwo1.setNode(two1);
        FadeTwo1.setDuration(Duration.millis(1250));
        FadeTwo1.setFromValue(0);
        FadeTwo1.setToValue(1.0);

        FadeThree1.setNode(three1);
        FadeThree1.setDuration(Duration.millis(1250));
        FadeThree1.setFromValue(0);
        FadeThree1.setToValue(1.0);

        FadeFour1.setNode(four1);
        FadeFour1.setDuration(Duration.millis(1250));
        FadeFour1.setFromValue(0);
        FadeFour1.setToValue(1.0);

        FadeFive1.setNode(five1);
        FadeFive1.setDuration(Duration.millis(1250));
        FadeFive1.setFromValue(0);
        FadeFive1.setToValue(1.0);

        FadeSix1.setNode(six1);
        FadeSix1.setDuration(Duration.millis(1250));
        FadeSix1.setFromValue(0);
        FadeSix1.setToValue(1.0);

        FadeSeven1.setNode(seven1);
        FadeSeven1.setDuration(Duration.millis(1250));
        FadeSeven1.setFromValue(0);
        FadeSeven1.setToValue(1.0);

        FadeEight1.setNode(eight1);
        FadeEight1.setDuration(Duration.millis(1250));
        FadeEight1.setFromValue(0);
        FadeEight1.setToValue(1.0);

        FadeNine1.setNode(nine1);
        FadeNine1.setDuration(Duration.millis(1250));
        FadeNine1.setFromValue(0);
        FadeNine1.setToValue(1.0);


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(0), Event -> FadeOne1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeTwo1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeThree1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeFour1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeFive1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeSix1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeSeven1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeEight1.play()),
                new KeyFrame(Duration.millis(0), Event -> FadeNine1.play()),
                new KeyFrame(Duration.millis(100), Event -> paneOne1.play()),
                new KeyFrame(Duration.millis(120), Event -> paneTwo1.play()),
                new KeyFrame(Duration.millis(140), Event -> paneThree1.play()),
                new KeyFrame(Duration.millis(160), Event -> paneFour1.play()),
                new KeyFrame(Duration.millis(180), Event -> paneFive1.play()),
                new KeyFrame(Duration.millis(200), Event -> paneSix1.play()),
                new KeyFrame(Duration.millis(220), Event -> paneSeven1.play()),
                new KeyFrame(Duration.millis(240), Event -> paneEight1.play()),
                new KeyFrame(Duration.millis(260), Event -> paneNine1.play())
        );
        timeline.play();

    }

    //zestaw animacji, ustawiający elementy programu(zakładka rolety) w odpowiedniej pozycji przy uruchomieniu
    public void reverseRBlindTransition() {
        paneOne1.setNode(one1);
        paneOne1.setDuration(Duration.millis(1));
        paneOne1.setByY(168);

        paneTwo1.setNode(two1);
        paneTwo1.setDuration(Duration.millis(1));
        paneTwo1.setByY(168);

        paneThree1.setNode(three1);
        paneThree1.setDuration(Duration.millis(1));
        paneThree1.setByY(168);

        paneFour1.setNode(four1);
        paneFour1.setDuration(Duration.millis(1));
        paneFour1.setByY(168);

        paneFive1.setNode(five1);
        paneFive1.setDuration(Duration.millis(1));
        paneFive1.setByY(168);

        paneSix1.setNode(six1);
        paneSix1.setDuration(Duration.millis(1));
        paneSix1.setByY(168);

        paneSeven1.setNode(seven1);
        paneSeven1.setDuration(Duration.millis(1));
        paneSeven1.setByY(168);

        paneEight1.setNode(eight1);
        paneEight1.setDuration(Duration.millis(1));
        paneEight1.setByY(168);

        paneNine1.setNode(nine1);
        paneNine1.setDuration(Duration.millis(1));
        paneNine1.setByY(168);

        Timeline RBlindTimeline = new Timeline(
                new KeyFrame(Duration.millis(1), Event -> paneOne1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneTwo1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneThree1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneFour1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneFive1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneSix1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneSeven1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneEight1.play()),
                new KeyFrame(Duration.millis(1), Event -> paneNine1.play())
        );
        RBlindTimeline.play();
    }

    //zestaw animacji, wywoływany w initialize w odpowiednim momencie
    public void TemperatureAnimSet() {
        paneOne2.setNode(one11);
        paneOne2.setDuration(Duration.millis(850));
        paneOne2.setByY(-168);

        paneTwo2.setNode(two11);
        paneTwo2.setDuration(Duration.millis(850));
        paneTwo2.setByY(-168);

        paneThree2.setNode(three11);
        paneThree2.setDuration(Duration.millis(850));
        paneThree2.setByY(-168);

        paneFour2.setNode(four11);
        paneFour2.setDuration(Duration.millis(850));
        paneFour2.setByY(-168);

        paneFive2.setNode(five11);
        paneFive2.setDuration(Duration.millis(850));
        paneFive2.setByY(-168);

        paneSix2.setNode(six11);
        paneSix2.setDuration(Duration.millis(850));
        paneSix2.setByY(-168);

        paneSeven2.setNode(seven11);
        paneSeven2.setDuration(Duration.millis(850));
        paneSeven2.setByY(-168);


        FadeOne2.setNode(one11);
        FadeOne2.setDuration(Duration.millis(1250));
        FadeOne2.setFromValue(0);
        FadeOne2.setToValue(1.0);

        FadeTwo2.setNode(two11);
        FadeTwo2.setDuration(Duration.millis(1250));
        FadeTwo2.setFromValue(0);
        FadeTwo2.setToValue(1.0);

        FadeThree2.setNode(three11);
        FadeThree2.setDuration(Duration.millis(1250));
        FadeThree2.setFromValue(0);
        FadeThree2.setToValue(1.0);

        FadeFour2.setNode(four11);
        FadeFour2.setDuration(Duration.millis(1250));
        FadeFour2.setFromValue(0);
        FadeFour2.setToValue(1.0);

        FadeFive2.setNode(five11);
        FadeFive2.setDuration(Duration.millis(1250));
        FadeFive2.setFromValue(0);
        FadeFive2.setToValue(1.0);

        FadeSix2.setNode(six11);
        FadeSix2.setDuration(Duration.millis(1250));
        FadeSix2.setFromValue(0);
        FadeSix2.setToValue(1.0);

        FadeSeven2.setNode(seven11);
        FadeSeven2.setDuration(Duration.millis(1250));
        FadeSeven2.setFromValue(0);
        FadeSeven2.setToValue(1.0);


        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(1), actionEvent -> FadeOne2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeTwo2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeThree2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeFour2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeFive2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeSix2.play()),
                new KeyFrame(Duration.millis(1), actionEvent -> FadeSeven2.play()),
                new KeyFrame(Duration.millis(100), actionEvent -> paneOne2.play()),
                new KeyFrame(Duration.millis(120), actionEvent -> paneTwo2.play()),
                new KeyFrame(Duration.millis(140), actionEvent -> paneThree2.play()),
                new KeyFrame(Duration.millis(160), actionEvent -> paneFour2.play()),
                new KeyFrame(Duration.millis(180), actionEvent -> paneFive2.play()),
                new KeyFrame(Duration.millis(200), actionEvent -> paneSix2.play()),
                new KeyFrame(Duration.millis(220), actionEvent -> paneSeven2.play())
        );
        timeline.play();

        //zestaw animacji, ustawiający elementy programu(zakładka temperatura) w odpowiedniej pozycji przy uruchomieniu
    }
    public void reverseTemperatureTransition() {
        paneOne2.setNode(one11);
        paneOne2.setDuration(Duration.millis(1));
        paneOne2.setByY(168);

        paneTwo2.setNode(two11);
        paneTwo2.setDuration(Duration.millis(1));
        paneTwo2.setByY(168);

        paneThree2.setNode(three11);
        paneThree2.setDuration(Duration.millis(1));
        paneThree2.setByY(168);

        paneFour2.setNode(four11);
        paneFour2.setDuration(Duration.millis(1));
        paneFour2.setByY(168);

        paneFive2.setNode(five11);
        paneFive2.setDuration(Duration.millis(1));
        paneFive2.setByY(168);

        paneSix2.setNode(six11);
        paneSix2.setDuration(Duration.millis(1));
        paneSix2.setByY(168);

        paneSeven2.setNode(seven11);
        paneSeven2.setDuration(Duration.millis(1));
        paneSeven2.setByY(168);


        Timeline TemperatureTimeline = new Timeline(
                new KeyFrame(Duration.millis(5), Event -> paneOne2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneTwo2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneThree2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneFour2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneFive2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneSix2.play()),
                new KeyFrame(Duration.millis(5), Event -> paneSeven2.play())
        );
        TemperatureTimeline.play();
    }

    //metoda nasłuchuje zmiany pozycji suwaków a następnie ustawia wartość w odpowiadających etykietach na podstawie tych zmian pozycji
    public void sliderListener(){

        lightsSlider1.valueProperty().addListener((observableValue, number, t1) -> {
            light1 = (int) lightsSlider1.getValue();
            label1.setText(light1 + "%");
        });

        lightsSlider2.valueProperty().addListener((observableValue, number, t1) -> {
            light2 = (int) lightsSlider2.getValue();
            label2.setText(light2 + "%");
        });

        lightsSlider3.valueProperty().addListener((observableValue, number, t1) -> {
            light3 = (int) lightsSlider3.getValue();
            label3.setText(light3 + "%");
        });

        lightsSlider4.valueProperty().addListener((observableValue, number, t1) -> {
            light4= (int) lightsSlider4.getValue();
            label4.setText(light4 + "%");
        });

        lightsSlider5.valueProperty().addListener((observableValue, number, t1) -> {
            light5 = (int) lightsSlider5.getValue();
            label5.setText(light5 + "%");
        });

        lightsSlider6.valueProperty().addListener((observableValue, number, t1) -> {
            light6 = (int) lightsSlider6.getValue();
            label6.setText(light6 + "%");
        });

        lightsSlider7.valueProperty().addListener((observableValue, number, t1) -> {
            light7 = (int) lightsSlider7.getValue();
            label7.setText(light7 + "%");
        });

        lightsSlider8.valueProperty().addListener((observableValue, number, t1) -> {
            light8 = (int) lightsSlider8.getValue();
            label8.setText(light8 + "%");
        });

        lightsSlider9.valueProperty().addListener((observableValue, number, t1) -> {
            light9 = (int) lightsSlider9.getValue();
            label9.setText(light9 + "%");
        });

        blindsSlider1.valueProperty().addListener((observableValue, number, t1) -> {
            rblind1 = (int) blindsSlider1.getValue();
            label11.setText(rblind1 + "%");
        });

        blindsSlider2.valueProperty().addListener((observableValue, number, t1) -> {
            rblind2 = (int) blindsSlider2.getValue();
            label21.setText(rblind2 + "%");
        });

        blindsSlider3.valueProperty().addListener((observableValue, number, t1) -> {
            rblind3 = (int) blindsSlider3.getValue();
            label31.setText(rblind3 + "%");
        });

        blindsSlider4.valueProperty().addListener((observableValue, number, t1) -> {
            rblind4 = (int) blindsSlider4.getValue();
            label41.setText(rblind4 + "%");
        });

        blindsSlider5.valueProperty().addListener((observableValue, number, t1) -> {
            rblind5 = (int) blindsSlider5.getValue();
            label51.setText(rblind5 + "%");
        });

        blindsSlider6.valueProperty().addListener((observableValue, number, t1) -> {
            rblind6 = (int) blindsSlider6.getValue();
            label61.setText(rblind6 + "%");
        });
        blindsSlider7.valueProperty().addListener((observableValue, number, t1) -> {
            rblind7 = (int) blindsSlider7.getValue();
            label71.setText(rblind7 + "%");
        });

        blindsSlider8.valueProperty().addListener((observableValue, number, t1) -> {
            rblind8 = (int) blindsSlider8.getValue();
            label81.setText(rblind8 + "%");
        });

        blindsSlider9.valueProperty().addListener((observableValue, number, t1) -> {
            rblind9 = (int) blindsSlider9.getValue();
            label91.setText(rblind9 + "%");
        });

        tempslider1.valueProperty().addListener((observableValue, number, t1) -> {
            temperature1 = (int) tempslider1.getValue();
            label111.setText(temperature1 + "°C");
        });

        tempslider2.valueProperty().addListener((observableValue, number, t1) -> {
            temperature2 = (int) tempslider2.getValue();
            label211.setText(temperature2 + "°C");
        });

        tempslider3.valueProperty().addListener((observableValue, number, t1) -> {
            temperature3 = (int) tempslider3.getValue();
            label311.setText(temperature3 + "°C");
        });

        tempslider4.valueProperty().addListener((observableValue, number, t1) -> {
            temperature4 = (int) tempslider4.getValue();
            label411.setText(temperature4 + "°C");
        });

        tempslider5.valueProperty().addListener((observableValue, number, t1) -> {
            temperature5 = (int) tempslider5.getValue();
            label511.setText(temperature5 + "°C");
        });

        tempslider6.valueProperty().addListener((observableValue, number, t1) -> {
            temperature6 = (int) tempslider6.getValue();
            label611.setText(temperature6 + "°C");
        });

        tempslider7.valueProperty().addListener((observableValue, number, t1) -> {
            temperature7 = (int) tempslider7.getValue();
            label711.setText(temperature7 + "°C");
        });

    //metoda służy do ustawiania wartości suwaków z bazy danych przy uruchamianiu programu
    }public void setSliderValue(Connection connection, String columnName, Slider slider, String tableName) {
        try {
            String sql = "SELECT " + columnName + " FROM " + tableName + " WHERE ID = 1 ";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int value = resultSet.getInt(columnName);
                slider.setValue(value);
            }
        } catch (SQLException ignored) {

        }
    }

    //metoda służy do aktualizowania danych w tabelach światła i rolety
     public void databaseValueUpdate(Button button, Label label, String tableName, String columnName) {
         button.setOnAction(event -> {
             try {
                 Connection conn = DriverManager.getConnection("jdbc:sqlite:project.db");
                 Statement stmt = conn.createStatement();
                 String temp = null;

                 //użyłem tutaj metody substring od getText().length() - 1, aby pozbyć się "%" na końcu i operować tylko na liczbach
                 temp = label.getText().substring(0, label.getText().length() - 1);
                 System.out.println(temp);

                 int labelValue = Integer.parseInt(temp);
                 stmt.executeUpdate("UPDATE " + tableName + " SET " + columnName + " = " + labelValue + " WHERE ID = 1");
                 conn.close();
             } catch (SQLException ignored) {
             }
         });
     }

    //metoda służy do aktualizowania danych z zakładki temperatura
    public void tempDatabaseValueUpdate(Button button, Label label, String tableName, String columnName) {
        button.setOnAction(event -> {
            try {
                Connection conn = DriverManager.getConnection("jdbc:sqlite:project.db");
                Statement stmt = conn.createStatement();
                String temp = null;

                //użyłem tutaj metody substring od getText().length() - 2, ponieważ "°C" to 2 znaki
                temp = label.getText().substring(0, label.getText().length() - 2);
                System.out.println(temp);

                int labelValue = Integer.parseInt(temp);
                stmt.executeUpdate("UPDATE " + tableName + " SET " + columnName + " = " + labelValue + " WHERE ID = 1");
                conn.close();
            } catch (SQLException ignored) {
            }
        });
    }


}

