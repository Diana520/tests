package org.example.two;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PlayerAnalyzerTest {

  @Test
  public void normalPlayerTest() {
    Player player = new Player("PlayerName", 25, 5, List.of(2, 2, 2));
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    List<Player> list = new ArrayList<>();
    list.add(player);
    double v = analyzer.calculateScore(list);
    assertEquals(250, v, 0);
  }

  @Test
  public void juniorPlayerTest() {
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    List<Player> list = new ArrayList<>();
    list.add(test2());
    double v = analyzer.calculateScore(list);
    assertEquals(67.5, v, 0);
  }

  @Test
  public void seniorPlayerTest() {
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    List<Player> list = new ArrayList<>();
    list.add(test3());
    double v = analyzer.calculateScore(list);
    assertEquals(2520, v, 0);
  }

  @Test
  public void multiplePlayers() {
    List<Player> list = test4();
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    double v = analyzer.calculateScore(list);
    assertTrue(v > 250);
    assertFalse(list.isEmpty());
  }

  @Test
  public void skillsNullTest() {
    List<Player> list = test5();
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    assertThrows(NullPointerException.class, () -> {
      analyzer.calculateScore(list);
    });
  }

  @Test
  public void emptyArray() {
    List<Player> list = new ArrayList<>();
    PlayerAnalyzer analyzer = new PlayerAnalyzer();
    assertEquals(0, analyzer.calculateScore(list), 0);
  }

  private Player test2() {
    Player player = new Player();
    player.setName("John"); // Set the player's name
    player.setAge(15);      // Set the player's age
    player.setExperience(3); // Set the player's experience
    List<Integer> skills = new ArrayList<>();
    skills.add(3);
    skills.add(3);
    skills.add(3);
    player.setSkills(skills);
    return player;
  }

  private Player test3() {
    Player player = new Player();
    player.setName("Alice"); // Set the player's name
    player.setAge(35);       // Set the player's age
    player.setExperience(15); // Set the player's experience
    List<Integer> skills = new ArrayList<>();
    skills.add(4);
    skills.add(4);
    skills.add(4);
    player.setSkills(skills); // Set the player's skills
    return player;
  }

  private ArrayList<Player> test5() {
    ArrayList<Player> playerList = new ArrayList<>();
    // Create player objects with null skills
    Player player1 = new Player();
    player1.setName("John");
    player1.setAge(25);
    player1.setExperience(3);
    player1.setSkills(null);
    playerList.add(player1);
    Player player2 = new Player();
    player2.setName("Alice");
    player2.setAge(28);
    player2.setExperience(5);
    player2.setSkills(null);
    playerList.add(player2);
    Player player3 = new Player();
    player3.setName("Bob");
    player3.setAge(22);
    player3.setExperience(1);
    player3.setSkills(null);
    playerList.add(player3);
    return playerList;
  }

  private List<Player> test4() {
    List<Player> playerList = new ArrayList<>();
    // Creating player objects
    Player player1 = new Player();
    player1.setName("John");
    player1.setAge(25);
    player1.setExperience(3);
    player1.setSkills(List.of(1, 2, 3));
    Player player2 = new Player();
    player2.setName("Jane");
    player2.setAge(28);
    player2.setExperience(5);
    player2.setSkills(List.of(4, 5, 6));
    // Adding players to the list
    playerList.add(player1);
    playerList.add(player2);
    return playerList;
  }
}