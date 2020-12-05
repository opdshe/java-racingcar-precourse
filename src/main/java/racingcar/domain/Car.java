package racingcar.domain;

import racingcar.domain.strategies.CarMovingStrategy;

public class Car {
    public static final int BOUNDARY_VALUE = 4;
    public static final int MAX_LENGTH_OF_CAR_NAME = 5;

    private final String name;
    private int position = 0;
    private CarMovingStrategy movingStrategy;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public Car(String name, CarMovingStrategy movingStrategy) {
        this.name = name;
        this.movingStrategy = movingStrategy;
    }

    public void go() {
        int movingNumber = movingStrategy.generate();
        if (isAvailableToGo(movingNumber)) {
            position++;
        }
    }

    private static boolean isAvailableToGo(int movingNumber) {
        return movingNumber >= BOUNDARY_VALUE;
    }

    public boolean isWinner(int maxPosition) {
        return getPosition() == maxPosition;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
