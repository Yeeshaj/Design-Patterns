package Structural.Adapter;

public class MediaPlayer {
    
    public static void main(String[] args) {
        MediaAdapter adapter = new MediaAdapter(new Mp4Player());
        adapter.startPlaying("tempfile");
        adapter.stopPlaying("tempfile");
    }

}


interface AdvancedMediaPlayer {
    void startPlaying(String fileName);
    void stopPlaying(String fileName);
}

class MediaAdapter implements AdvancedMediaPlayer {
    private Player player;

    MediaAdapter(Player player) {
        this.player = player;
    }

    void setPlayer(Player player){
        this.player = player;
    }

    @Override
    public void startPlaying(String fileName) {
        player.play(fileName);
    }

    @Override
    public void stopPlaying(String fileName) {
        player.stop(fileName);
    }
}



interface Player {
    void play(String filename );
    void stop(String filename);
}

class VlcPlayer implements Player  {

    @Override
    public void play(String filename) {
        System.out.println("Playing vlc  file : "+filename);
    }

    @Override
    public void stop(String filename) {
        System.out.println("Stopping vlc  file : "+filename);
    }
    
}

class Mp4Player implements Player{

    @Override
    public void play(String filename) {
        System.out.println("Playing mp4  file : "+filename);
    }

    @Override
    public void stop(String filename) {
        System.out.println("Stopping mp4  file : "+filename);
    }
}


