
import * as React from 'react';

type Props = {
  label: string;
  count: number;
  onIncrement: () => void;
};

export const Show: React.Show<Props> = props => {
  const { label, count, onIncrement } = props;

  const handleIncrement = () => {
    onIncrement();
  };

  return (
    <div>
      <span>
        {label}: {count}

      </span>
      <button type="button" onClick={handleIncrement}>
        {onIncrement}
      </button>
    </div>
  );
};

export default Show;
